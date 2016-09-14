package ad.joyplus.com.appadsdk.entity;

import java.util.List;

/**
 * Created by UPC on 2016/8/31.
 */
public class OpeningAdModel{

        private List<String> imageurl;
        private List<String> impressionurl;
        private List<String> clickurl;
        private List<String> showcount;

        public List<String> getImageurl() {
            return imageurl;
        }

        public void setImageurl(List<String> imageurl) {
            this.imageurl = imageurl;
        }

        public List<String> getImpressionurl() {
            return impressionurl;
        }

        public void setImpressionurl(List<String> impressionurl) {
            this.impressionurl = impressionurl;
        }

        public List<String> getClickurl() {
            return clickurl;
        }

        public void setClickurl(List<String> clickurl) {
            this.clickurl = clickurl;
        }

        public List<String> getShowcount() {
            return showcount;
        }

        public void setShowcount(List<String> showcount) {
            this.showcount = showcount;
        }

}
