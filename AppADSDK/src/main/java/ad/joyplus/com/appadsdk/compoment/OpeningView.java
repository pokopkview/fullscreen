package ad.joyplus.com.appadsdk.compoment;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import ad.joyplus.com.appadsdk.entity.OpeningAdModel;
import ad.joyplus.com.appadsdk.managers.AppADSDKManager;

/**
 * 用于开屏广告的组件
 * <p/>
 * <p/>
 * Created by UPC on 2016/8/29.
 */
public class OpeningView extends BaseComponent implements IComponent, View.OnClickListener {
    private OpeningAdModel openmodel;

    public OpeningView(Context context) {
        this(context, null);
    }

    public OpeningView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OpeningView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void disPlay() {
        openmodel = AppADSDKManager.getOpeningModel();
        request.getImgFromGlide(this,openmodel.getImageurl().get(0),mContext);
        //request.getGifFromGlide(this,"/data/data/ad.joyplus.com.sdkdemos/files/634d7b671791de4cfb990cebce684462.mp4",mContext);
        reportInfo(openmodel.getImpressionurl().get(0));//上报
        this.setOnClickListener(this);
    }

    @Override
    public void removeclick() {
        this.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        System.out.println(v.getId() + "---------");
        if (openmodel == null) {
            Log.e("AppADSDK", "openmodel was null");
            return;
        }
        //// TODO: 2016/9/7 确定点击之后的走向：
        //// TODO: 1 直接上报点击的url 2 跳转webview查看信息

        openmodel.getClickurl();

    }
}
