package ad.joyplus.com.retorfitokhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ad.joyplus.com.retorfitokhttp.builder.client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomepageService service =  HttpFectory.create();
        Call call = service.getHomePage();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(response.toString());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        client clients = new client.builder()
                .baseurl("")
                .url("")
                .params("","")
                .builders();
    }
}
