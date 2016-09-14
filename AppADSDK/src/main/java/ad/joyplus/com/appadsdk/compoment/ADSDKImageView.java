package ad.joyplus.com.appadsdk.compoment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import ad.joyplus.com.appadsdk.managers.AppADSDKManager;
import ad.joyplus.com.appadsdk.entity.OpeningAdModel;

/**
 * Created by UPC on 2016/9/9.
 */
public class ADSDKImageView extends BaseComponent implements IComponent,View.OnClickListener {
    //private ImageViewModel imageViewModel;
    private OpeningAdModel openingAdModel;

    public ADSDKImageView(Context context) {
        this(context,null);
    }

    public ADSDKImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ADSDKImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        disPlay();
    }

    @Override
    public void disPlay() {
        openingAdModel = AppADSDKManager.getOpeningModel();
        //request.LoadImages(openingAdModel.getImageurl().get(0),this);
        request.getImgFromGlide(this,openingAdModel.getImageurl().get(0),mContext);
        reportInfo(openingAdModel.getImpressionurl().get(0));//上报
        this.setOnClickListener(this);
    }

    @Override
    public void removeclick() {
        this.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(mContext,"图片被点击了",Toast.LENGTH_LONG).show();

    }
}
