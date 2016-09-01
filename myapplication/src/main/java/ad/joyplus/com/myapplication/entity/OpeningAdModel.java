package ad.joyplus.com.myapplication.entity;

/**
 * Created by UPC on 2016/8/31.
 */
public class OpeningAdModel<T> extends BaseModel {

    /**
     * 资源下载链接
     */
    private T ImageURL;

    /**
     * 上报链接
     */
    private T ImpressionURL;

    /**
     * 点击链接
     */
    private T clickURL;


    public T getImageURL() {
        return ImageURL;
    }

    public void setImageURL(T imageURL) {
        ImageURL = imageURL;
    }

    public T getImpressionURL() {
        return ImpressionURL;
    }

    public void setImpressionURL(T impressionURL) {
        ImpressionURL = impressionURL;
    }

    public T getClickURL() {
        return clickURL;
    }

    public void setClickURL(T clickURL) {
        this.clickURL = clickURL;
    }
}
