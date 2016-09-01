package ad.joyplus.com.myapplication.entity;

import java.util.List;

/**
 * Config内的格式或是参数需要再具体定义
 *
 *
 * Created by UPC on 2016/8/29.
 */
public class ConfigModel {

    /**
     * 广告为ID
     */
    private List<String> publishID;
    /**
     *请求的服务器地址
     */
    private String baseURL;
    /**
     *储存广告的空间
     */
    private String maxSize;

    public String getVconfig() {
        return Vconfig;
    }

    public void setVconfig(String vconfig) {
        Vconfig = vconfig;
    }

    /**
     * 配置文件版本
     */

    private String Vconfig;

    public List<String> getPublishID() {
        return publishID;
    }

    public void setPublishID(List<String> publishID) {
        this.publishID = publishID;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
