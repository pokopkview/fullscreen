package ad.joyplus.com.sdkdemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import ad.joyplus.com.appadsdk.compoment.ADSDKImageView;
import ad.joyplus.com.appadsdk.managers.AppADSDKManager;

public class SecendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        ADSDKImageView imageView = new ADSDKImageView(this);
        String endmedia = AppADSDKManager.getEndMediaModel();
        ((RelativeLayout)findViewById(R.id.rl_secend)).addView(imageView);
        ((Button)findViewById(R.id.bt_nextpage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten  = new Intent(SecendActivity.this,ThridActivity.class);
                startActivity(inten);
            }
        });
    }
}
