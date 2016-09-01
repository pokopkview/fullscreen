package ad.joyplus.com.myapplication.compoment;

import ad.joyplus.com.myapplication.entity.ReportInfoModel;

/**
 * Created by UPC on 2016/8/31.
 */
public interface IComponent<T> {
    boolean reportinfo(ReportInfoModel reportinfo);
    T getADResource(String filepath);
    void disPlay();
}
