package ad.joyplus.com.appadsdk.entity;

import ad.joyplus.com.appadsdk.AppUtil.AppInfoUtils;

/**
 * 上报信息的model
 * Created by UPC on 2016/8/31.
 */
public class ReportInfoModel{

    private String impressionurl;

    private long reportTime;

    private String macInfo;

    private String ipInfo;

    private String deviceinfo;


    public String getImpressionurl() {
        return impressionurl;
    }

    public void setImpressionurl(String impressionurl) {
        this.impressionurl = impressionurl;
    }

    public long getReportTime() {
        return System.currentTimeMillis();
    }

    public String getMacInfo() {
        return AppInfoUtils.getMacInfo();
    }


    public String getIpInfo() {
        return AppInfoUtils.getIPinfo();
    }

    public String getDeviceinfo() {
        return AppInfoUtils.getDeviceinfo();
    }
    public String toURL(){




        return "";
    }
}
