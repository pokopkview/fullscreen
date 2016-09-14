package ad.joyplus.com.sdkdemos;

/**
 * Created by UPC on 2016/9/8.
 */
public class tests<T>{


    /**
     * publishID : {"open":"open","startmedia":"startmedia","endmedia":"endmedia"}
     * baseURL : 987654321
     * maxSize : 555555555
     * showcount : 9
     */
        /**
         * open : open
         * startmedia : startmedia
         * endmedia : endmedia
         */

        private T publishID;
        private String baseURL;
        private String maxSize;
        private String showcount;

        public T getPublishID() {
            return publishID;
        }

        public void setPublishID(T publishID) {
            this.publishID = publishID;
        }

        public String getBaseURL() {
            return baseURL;
        }

        public void setBaseURL(String baseURL) {
            this.baseURL = baseURL;
        }

        public String getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(String maxSize) {
            this.maxSize = maxSize;
        }

        public String getShowcount() {
            return showcount;
        }

        public void setShowcount(String showcount) {
            this.showcount = showcount;
        }

}
