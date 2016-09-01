package ad.joyplus.com.myapplication.compoment;

import android.content.Context;
import android.view.View;

import ad.joyplus.com.myapplication.entity.ReportInfoModel;

/**
 * Created by UPC on 2016/8/31.
 */
public abstract class BaseComponent extends View implements IComponent{


    public BaseComponent(Context context) {
        super(context);
    }

    /**
     * 上报信息
     * @param reportinfo
     * @return
     */
    @Override
    public boolean reportinfo(ReportInfoModel reportinfo) {
        return false;
    }

    /**
     * 获取需要展示的资源
     * @param filepath
     * @return
     */
    @Override
    public Object getADResource(String filepath) {
        return null;
    }

    /**
     * 展示AD
     */
    @Override
    public void disPlay() {

    }
}
