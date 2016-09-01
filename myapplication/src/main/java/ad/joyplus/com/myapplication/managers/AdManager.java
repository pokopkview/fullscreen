package ad.joyplus.com.myapplication.managers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import ad.joyplus.com.myapplication.entity.ConfigModel;
import ad.joyplus.com.myapplication.network.IRequest;
import ad.joyplus.com.myapplication.network.NetworkFactory;
import ad.joyplus.com.myapplication.network.RequestIterface;

/**
 * Created by UPC on 2016/8/31.
 */
public class AdManager {

    private Context mContext;
    private IRequest request;

    public String getOpeningURL() {
        return openingURL;
    }

    public void setOpeningURL(String openingURL) {
        this.openingURL = openingURL;
    }

    private String openingURL;
    private String startmediaurl;
    private String endmediaurl;
    private ConfigModel model;

    public AdManager(Context context) {
        this.mContext = context;
        request = NetworkFactory.newInstance(context);
        if(getModelFromSp() == null){
            request.getConfigInfo("", new RequestIterface.IModelCallBack<ConfigModel>() {
                @Override
                public void onConfigModelBack(ConfigModel configModel) {
                    setConfigInfotoPrefrence(configModel);
                }
            });
        }
    }

    /**
     * 调用manager的initOPeningAD，使用者传入开屏页面的view，SDK将会下载并展示到该View上面
     *
     * @param view
     */
    public void initOPeningAD(ImageView view) {
        request.LoadImages(openingURL, view);
        setOnclickTH(view);
    }

    /**
     * 获取视频前贴片的媒体资源地址
     *
     * @return
     */
    public String getStartMedia() {
        return startmediaurl;
    }

    /**
     * 获取视频的后贴片媒体资源地址
     *
     * @return
     */
    public String getEndMedia() {
        return endmediaurl;
    }

    private void setOnclickTH(ImageView view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 处理图片的点击事件,跳转或是其他
                 */
                Gson gson = new Gson();
//                /**
//                 * 使用typetoken类来解析T泛型类
//                 */
//                Type type = new TypeToken<AdModel<OpeningAdModel<List<String>>>>(){}.getType();
//                gson.fromJson("",type);
//                AdModel<OpeningAdModel<List<String>>> model = new AdModel<OpeningAdModel<List<String>>>();
            }
        });
    }

    /**
     * 当有新版本已经更新后调用该方法来更新
     */

    public void getInfoFromShare(){
        /**
         * 第一次启动的时候将会请求Config配置，之后将会在每次请求的版本号上进行判断并是否请求
         */
        final SharedPreferences preferences = mContext.getSharedPreferences("config", Activity.MODE_PRIVATE);
        String configverson = preferences.getString("config_verson", "");
        if (TextUtils.isEmpty(configverson)) {
            request.getConfigInfo("", new RequestIterface.IModelCallBack<ConfigModel>() {
                @Override
                public void onConfigModelBack(ConfigModel configModel) {
                    //返回的configmodel的实体类
                }
            });
        }else{

        }
    }

    /**
     * 将Config配置信息写入shareprefrence
     * @param model
     */
    private void setConfigInfotoPrefrence(ConfigModel model){
        SharedPreferences preferences = mContext.getSharedPreferences("config",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("info_json",new Gson().toJson(model));
        editor.commit();
    }

    /**
     * 从shareprefrence里面获取Config配置信息
     * @return ConfigModel
     */
    public ConfigModel getModelFromSp(){
        SharedPreferences preferences = mContext.getSharedPreferences("config",Activity.MODE_PRIVATE);
        String info_json = preferences.getString("info_json","");
        return new Gson().fromJson(info_json,ConfigModel.class);
    }
}
