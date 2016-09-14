package ad.joyplus.com.appadsdk.managers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

import ad.joyplus.com.appadsdk.AppUtil.ILoadUtils;
import ad.joyplus.com.appadsdk.compoment.OpeningView;
import ad.joyplus.com.appadsdk.entity.AdModel;
import ad.joyplus.com.appadsdk.entity.ConfigModel;
import ad.joyplus.com.appadsdk.entity.EndMediaModel;
import ad.joyplus.com.appadsdk.entity.ImageViewModel;
import ad.joyplus.com.appadsdk.entity.OpeningAdModel;
import ad.joyplus.com.appadsdk.entity.StartMediaModel;
import ad.joyplus.com.appadsdk.network.IRequest;
import ad.joyplus.com.appadsdk.network.NetworkFactory;
import ad.joyplus.com.appadsdk.network.RequestIterface;

/**
 * Manager类具体来管理相关广告的请求及配置信息的读写、更新等
 * <p/>
 * Created by UPC on 2016/8/31.
 */
public class AppADSDKManager {

    private static Context mContext;
    private static IRequest request;
    private static ConfigModel<Map<String ,String>> model;
    private static OpeningAdModel openingAdModel;
    private static StartMediaModel startMediaModel;
    private static EndMediaModel endMediaModel;
    private static ImageViewModel imageViewModel;
    private static OpeningView view ;
    private static ILoadUtils loadlistener;

    //常量
    public static final int OPEN = 001;
    public static final int STARTMEDIA = 002;
    public static final int ENDMEDIA = 003;
    public static final int IMAGEDATA = 004;
    /**
     * 调用manager的initOPeningAD，使用者传入开屏页面的view，SDK将会下载并展示到该View上面
     * 使用该方法时，是需要自己先建立ImageView的，另外的方法是直接调用OpeningScreenAD在布局上使用
     */
    public static void init(Context context) {
        mContext = context;
        view = new OpeningView(mContext);
        request = NetworkFactory.newInstance(mContext);
        model = getModelFromSp();
        if (model == null) {
                getInfoFromShare();
        }else{
            getAllModelFromConfig();
        }
    }

    public static OpeningView getOpenView() {
        return view;
    }
    public static ImageViewModel getImageViewModel(){
        return imageViewModel;
    }

    public static OpeningAdModel getOpeningModel(){
        return openingAdModel;
    }
    public static String getStartMediaModel(){
        //TODO:直接给视频链接的方式的上报还需要再分析
        refreshMediaInfo();//
        return startMediaModel.getVideourl();
    }
    public static String getEndMediaModel(){
        refreshMediaInfo();
        return endMediaModel.getVideourl();
    }
    //分别请求
    private static void getAllModelFromConfig(){
        System.out.println("getAllModelFromConfig");
        request.getBaseModel(AppADSDKManager.OPEN, "http://www.adjoy.com/test/test/getPublishID?publishID=" + model.getPublishID().get("open"), new RequestIterface.IADmodel() {
            @Override
            public void onAdModelBack(AdModel model) {
                openingAdModel = (OpeningAdModel) model.data;
                view.disPlay();
                loadlistener.hasLoad();
                checkversionCode(model.VersonCode);
                request.getBaseModel(AppADSDKManager.STARTMEDIA, "http://www.adjoy.com/test/test/getPublishID?publishID=" + AppADSDKManager.model.getPublishID().get("startmedia"), new RequestIterface.IADmodel() {
                    @Override
                    public void onAdModelBack(AdModel model) {
                        startMediaModel = (StartMediaModel) model.data;
                        checkversionCode(model.VersonCode);
                        request.getBaseModel(AppADSDKManager.ENDMEDIA, "http://www.adjoy.com/test/test/getPublishID?publishID=" + AppADSDKManager.model.getPublishID().get("endmedia"), new RequestIterface.IADmodel() {
                            @Override
                            public void onAdModelBack(AdModel model) {
                                endMediaModel = (EndMediaModel) model.data;
                                checkversionCode(model.VersonCode);
                                request.getBaseModel(AppADSDKManager.IMAGEDATA, "http://www.adjoy.com/test/test/getPublishID?publishID=" + AppADSDKManager.model.getPublishID().get(openingAdModel), new RequestIterface.IADmodel() {
                                    @Override
                                    public void onAdModelBack(AdModel model) {
                                        imageViewModel = (ImageViewModel) model.data;
                                        checkversionCode(model.VersonCode);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    public static void setLoadListener(ILoadUtils iloadlistener){
        loadlistener = iloadlistener;
    }

    /**
     * 但版本号有变化则直接调该方法来更新当前的Config配置
     */

    private static void getInfoFromShare() {
        request.getConfigInfo("http://www.adjoy.com/test/test/getAppVersion", new RequestIterface.IModelCallBack() {
            @Override
            public void onConfigModelBack(AdModel<ConfigModel<Map<String,String>>> adModel) {
                setConfigInfotoPrefrence(adModel);
                model = adModel.data;
                getAllModelFromConfig();
            }
        });
    }
    /**
     * 将Config配置信息写入shareprefrence
     *
     * @param model
     */
    private static void setConfigInfotoPrefrence(AdModel<ConfigModel<Map<String,String>>> model) {
        SharedPreferences preferences = mContext.getSharedPreferences("config", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("config_verson", model.VersonCode);
        editor.putString("info_json", new Gson().toJson(model.data));
        editor.commit();
    }

    /**
     * 从shareprefrence里面获取Config配置信息
     * @return ConfigModel
     */
    public static ConfigModel getModelFromSp() {
        SharedPreferences preferences = mContext.getSharedPreferences("config", Activity.MODE_PRIVATE);
        String info_json = preferences.getString("info_json", "");
        System.out.println(info_json);
        return new Gson().fromJson(info_json, new TypeToken<ConfigModel<Map<String ,String>>>(){}.getType());
    }

    /**
     * 判断传入的版本号，如果版本号有升级则请求AppSDk的配置文件
     * @param newcode 传入的版本
     */
    private static void checkversionCode(String newcode){
        SharedPreferences preferences = mContext.getSharedPreferences("config", Activity.MODE_PRIVATE);
        String version = preferences.getString("config_verson", "");
        if(!newcode.equals(version)){
            getInfoFromShare();
        }
    }
    private static void refreshMediaInfo(){
       request.getBaseModel(AppADSDKManager.STARTMEDIA, model.getBaseURL() + model.getPublishID().get("startmedia"), new RequestIterface.IADmodel() {
           @Override
           public void onAdModelBack(AdModel model) {
               startMediaModel = (StartMediaModel) model.data;
           }
       });
        request.getBaseModel(AppADSDKManager.ENDMEDIA, model.getBaseURL() + model.getPublishID().get("endmedia"), new RequestIterface.IADmodel() {
            @Override
            public void onAdModelBack(AdModel model) {
                endMediaModel = (EndMediaModel) model.data;
            }
        });
    }
}
