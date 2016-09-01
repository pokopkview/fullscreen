package ad.joyplus.com.retorfitokhttp;

import ad.joyplus.com.retorfitokhttp.entity.HomePageModel;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UPC on 2016/8/26.
 */
public interface HomepageService {
    @GET("index?device=lihongwei&mac_addr=lihongwei&v=1&p=1")
    Call<HomePageModel> getHomePage();
}
