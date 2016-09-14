package ad.joyplus.com.sdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import ad.joyplus.com.myapplication.managers.AdManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdManager adManager = new AdManager(this);
        adManager.setOpeningURL("http://www.bz55.com/uploads/allimg/150309/139-150309101A0.jpg");
        adManager.initOPeningAD((ImageView) findViewById(R.id.iv_openingscreen));
    }
}
