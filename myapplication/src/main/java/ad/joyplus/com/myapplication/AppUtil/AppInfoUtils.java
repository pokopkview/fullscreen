package ad.joyplus.com.myapplication.AppUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

/**
 * AppInfoUtils用于获取app信息及当前机器的信息
 * <p/>
 * Created by UPC on 2016/8/29.
 */
public class AppInfoUtils {

    private static Context mContext;

    public AppInfoUtils() {

    }

    public static void init(Context context) {
        mContext = context;
    }

    /**
     * 获取设备的Mac地址
     * @return
     */
    public static String getMacInfo() {
        try {
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (interfaceEnumeration.hasMoreElements()) {
                NetworkInterface ni = interfaceEnumeration.nextElement();
                byte[] addr = ni.getHardwareAddress();
                if (addr == null || addr.length == 0) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                for (byte b : addr) {
                    sb.append(String.format("%02X", b));
                    sb.append(":");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                String Mac = sb.toString();
                return Mac;
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "getMacInfo";
    }

    /**
     * 获取设备的IP信息
     * @return
     */
    public static String getIPinfo() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface
                    .getNetworkInterfaces(); enNetI.hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取设备的DeviceID信息
     * @return
     */
    public static String getDeviceinfo() {
        final String PREFS_FILE = "device_id.xml";
        final String PREFS_DEVICE_ID = "device_id";
        UUID uuid = null;
        if (uuid == null) {
            synchronized (AppInfoUtils.class) {
                if (uuid == null) {
                    final SharedPreferences prefs = mContext
                            .getSharedPreferences(PREFS_FILE, 0);
                    final String id = prefs.getString(PREFS_DEVICE_ID, null);
                    if (id != null) {
                        uuid = UUID.fromString(id);
                    } else {
                        final String androidId = Settings.Secure.getString(
                                mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
                        try {
                            if (!"9774d56d682e549c".equals(androidId)) {
                                uuid = UUID.nameUUIDFromBytes(androidId
                                        .getBytes("utf8"));
                            } else {
                                final String deviceId = ((TelephonyManager)
                                        mContext.getSystemService(
                                                Context.TELEPHONY_SERVICE)).getDeviceId();
                                uuid = deviceId != null ? UUID
                                        .nameUUIDFromBytes(deviceId
                                                .getBytes("utf8")) : UUID
                                        .randomUUID();
                            }
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                        prefs.edit()
                                .putString(PREFS_DEVICE_ID, uuid.toString())
                                .commit();
                    }
                }
            }
        }
        return uuid.toString();
    }


}
