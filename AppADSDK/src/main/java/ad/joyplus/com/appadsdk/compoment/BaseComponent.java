package ad.joyplus.com.appadsdk.compoment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import ad.joyplus.com.appadsdk.network.RequestIterface;
import ad.joyplus.com.appadsdk.network.IRequest;
import ad.joyplus.com.appadsdk.network.NetworkFactory;

/**
 * Created by UPC on 2016/9/6.
 */
public class BaseComponent extends ImageView{
    protected IRequest request;
    protected Context mContext;

    public BaseComponent(Context context) {
        this(context,null);
    }

    public BaseComponent(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        this.request = NetworkFactory.newInstance(context);
    }

    protected void reportInfo(String impressionurl){
        System.out.println("将要上报的信息："+impressionurl);
        //TODO
        request.reportInfo(impressionurl, new RequestIterface.IReportInfoCallBack() {
            @Override
            public void onReportBack(boolean state) {
                if(state){


                }else{
                    //失败处理
                }
            }
        });
    }
}
