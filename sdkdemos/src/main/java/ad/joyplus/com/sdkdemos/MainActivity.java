package ad.joyplus.com.sdkdemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ad.joyplus.com.appadsdk.AppUtil.ILoadUtils;
import ad.joyplus.com.appadsdk.compoment.OpeningView;
import ad.joyplus.com.appadsdk.managers.AppADSDKManager;

public class MainActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppADSDKManager.init(this);
        String startmedia = AppADSDKManager.getStartMediaModel();
        String endmedia = AppADSDKManager.getEndMediaModel();
        final OpeningView views = (OpeningView) findViewById(R.id.ov_opening);
        AppADSDKManager.setLoadListener(new ILoadUtils() {
            @Override
            public void hasLoad() {
                views.disPlay();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, SecendActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);
            }
        });
    }
}