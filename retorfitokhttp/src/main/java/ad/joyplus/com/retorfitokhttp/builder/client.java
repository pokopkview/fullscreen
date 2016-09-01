package ad.joyplus.com.retorfitokhttp.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by UPC on 2016/8/29.
 */
public class client {
    private builder mbuilder;

    public client(builder mbuilder){
        this.mbuilder = mbuilder;
    }

    public static final class builder {
        private String baseurl = "www.adjoy.com";
        private String url;
        private Map<String,String> params = new HashMap<>();

        public builder() {}


        public builder baseurl(String url){
            this.baseurl = url;
            return this;
        }

        public builder url(String url){
            this.url = url;
            return this;
        }

        public builder params(String key,String value){
            params.put(key,value);
            return this;
        }

        public client builders(){
            return new client(this);
        }


    }
}
