package ad.joyplus.com.retorfitokhttp.entity;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by UPC on 2016/7/1.
 */
public class LoadConfig {
    public static String HOMEPAGEURL;
    public static String COLLECTION;
    public static String WATCHACTION;
    public static String CONTENTPAGE;
    public static String BANNERDETAIL;
    public static String USERCOLLECTION;
    public static String PLAYEDTIME;
    public static String KEYWORDSEARCH;



    private static Properties properties = new Properties();

    public static void init(Context context){
        try {
            properties.load(context.getAssets().open("url.properties"));
//            DataUtil.setHOMEPAGEURL(properties.getProperty("HOMEPAGEURL"));
//            DataUtil.setCONTENTPAGE(properties.getProperty("CONTENTPAGE"));
//            DataUtil.setCOLLECTION(properties.getProperty("COLLECTION"));
//            DataUtil.setWATCHACTION(properties.getProperty("WATCHACTION"));
//            DataUtil.setBANNERDETAIL(properties.getProperty("BANNERDETAIL"));
//            DataUtil.setUSERCOLLECTION(properties.getProperty("USERCOLLECTION"));
//            DataUtil.setPLAYEDTIME(properties.getProperty("PLAYEDTIME"));
//            DataUtil.setKEYWORDSEARCH(properties.getProperty("KEYWORDSEARCH"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * MAINSIDE=http://www.adjoy.com/app/home/index
     SEARCHURL=
     HOMEPAGEURL=http://www.adjoy.com/app/home/index
     CONTENTPAGE=http://www.adjoy.com/app/home/materialDetail
     COLLECTION=http://www.adjoy.com/app/home/userCollection
     WATCHACTION=http://www.adjoy.com/app/home/userWatchAction
     BANNERDETAIL=http://www.adjoy.com/app/home/getBannerDetails
     * @return
     */

}
