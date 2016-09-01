package ad.joyplus.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ad.joyplus.com.myapplication.AppUtil.AppInfoUtils;
import ad.joyplus.com.myapplication.managers.AdManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppInfoUtils.init(this);
        AdManager adManager = new AdManager(this);
//        adManager.setOpeningURL("http://bbs.qingcheng.com/data/attachment/forum/201312/06/214540rustek7ztim11k7k.jpg");
//        adManager.initOPeningAD((ImageView) findViewById(R.id.img_bigshow));
        System.out.println(adManager.getModelFromSp()+"-----");

        System.out.println(AppInfoUtils.getIPinfo()+"|||"+AppInfoUtils.getDeviceinfo()+"|||"+AppInfoUtils.getMacInfo());
    }
}
