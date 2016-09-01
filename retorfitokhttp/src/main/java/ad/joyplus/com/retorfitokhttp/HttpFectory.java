package ad.joyplus.com.retorfitokhttp;

import retrofit2.Retrofit;

/**
 * Created by UPC on 2016/8/26.
 */
public class HttpFectory {

    public static HomepageService create(){
        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("http://www.adjoy.com/app/home/")
                .build();
        return retrofit.create(HomepageService.class);

    }

}
