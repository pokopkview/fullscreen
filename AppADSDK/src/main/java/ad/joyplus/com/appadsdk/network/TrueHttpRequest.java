package ad.joyplus.com.appadsdk.network;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import ad.joyplus.com.appadsdk.entity.AdModel;
import ad.joyplus.com.appadsdk.entity.ConfigModel;
import ad.joyplus.com.appadsdk.entity.EndMediaModel;
import ad.joyplus.com.appadsdk.entity.OpeningAdModel;
import ad.joyplus.com.appadsdk.entity.StartMediaModel;
import ad.joyplus.com.appadsdk.managers.AppADSDKManager;
import ad.joyplus.com.myapplication.R;

/**
 * 网络接口具体的实现类
 * 利用第三方Volley框架进行Http请求
 * Created by UPC on 2016/8/29.
 */
public class TrueHttpRequest implements IRequest {
    private RequestQueue mQueue;
    private Gson mGson;


    public TrueHttpRequest(Context context) {
        mQueue = Volley.newRequestQueue(context);
        mGson = new Gson();
    }
    @Override
    public void getBaseModel(final int type, String url, final RequestIterface.IADmodel models){
        TrueConfigInfomation(url, new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                System.out.println(type);
                if (type == AppADSDKManager.OPEN){
                    System.out.println(reqeust);
                    Type type1 = new TypeToken<AdModel<OpeningAdModel>>(){}.getType();
                    System.out.println(type1.toString());
                    AdModel<OpeningAdModel> openingAdModel = mGson.fromJson(reqeust.toString(),type1);
                    System.out.println(openingAdModel.data.getImageurl().toString());
                    models.onAdModelBack(openingAdModel);
                }else if(type == AppADSDKManager.STARTMEDIA){
                    String xml = "{\n" +
                            "\"Code\":\"1\",\n" +
                            "\"VersonCode\":\"1.0\",\n" +
                            "\"msg\":\"ok\",\n" +
                            "\"data\":{\n" +
                            "    \"videourl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"impressionurl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"clickurl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"showtime\":\"15\"\n" +
                            "}\n" +
                            "}";

                    AdModel<StartMediaModel> startMediaModelAdModel = mGson.fromJson(xml,new TypeToken<AdModel<StartMediaModel>>(){}.getType());
                    models.onAdModelBack(startMediaModelAdModel);
                }else if(type == AppADSDKManager.ENDMEDIA){
                    String xml = "{\n" +
                            "\"Code\":\"1\",\n" +
                            "\"VersonCode\":\"1.0\",\n" +
                            "\"msg\":\"ok\",\n" +
                            "\"data\":{\n" +
                            "    \"videourl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"impressionurl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"clickurl\":\"http://image60.360doc.com/DownloadImg/2013/04/2119/31799685_31.jpg\",\n" +
                            "    \"showtime\":\"15\"\n" +
                            "}\n" +
                            "}";
                    AdModel<EndMediaModel> endMediaModelAdModel = mGson.fromJson(xml,new TypeToken<AdModel<EndMediaModel>>(){}.getType());
                    models.onAdModelBack(endMediaModelAdModel);
                }
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {

            }
        });
    }

    @Override
    public void getImgFromGlide(ImageView view, String url, Object object) {
        LoadImgFromGlide(view,url,object);
    }

    @Override
    public void getGifFromGlide(ImageView view, String url, Context context) {
        Glide.with(context).load( Uri.fromFile( new File( url ) )).into(view);
        //Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
    }

    @Override
    public void getConfigInfo(String url, final RequestIterface.IModelCallBack callBack) {
        TrueConfigInfomation("http://www.baidu.com", new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                reqeust = "{\n" +
                        "\"Code\":\"1\",\n" +
                        "\"VersonCode\":\"1.0\",\n" +
                        "\"msg\":\"ok\",\n" +
                        "\"data\":{\n" +
                        "    \"publishID\":{\"open\":\"open\",\"startmedia\":\"startmedia\",\"endmedia\":\"endmedia\"},\n" +
                        "    \"baseURL\":\"987654321\",\n" +
                        "    \"maxSize\":\"555555555\",\n" +
                        "    \"showcount\":\"9\"\n" +
                        "}\n" +
                        "}";
                AdModel<ConfigModel<Map<String,String>>> adModel = mGson.fromJson(reqeust.toString(), new TypeToken<AdModel<ConfigModel<Map<String,String>>>>() {
                }.getType());
                callBack.onConfigModelBack(adModel);
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {
                Log.e("HttpError", request.toString());
            }
        });
    }

    /**
     * 获取开屏对应资源的信息
     * @param url
     * @param callBack
     */
    @Override
    public void getOpeningInfo(String url, final RequestIterface.IOpeningInfoCallBack callBack) {
        TrueConfigInfomation(url, new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                AdModel<OpeningAdModel> model = mGson.fromJson(reqeust.toString(), new TypeToken<AdModel<OpeningAdModel>>(){}.getType());
                callBack.onOpeningBack(model.data);
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {

            }
        });
    }

    /**
     * 获取配置信息的方法
     *
     * @param url
     */


    @Override
    public void DownLoadFiles(String targetFilepath, String url, RequestIterface.IDownLoadProgress progress, RequestIterface.IDownLoadSuccess success) {
        DownLodResource(targetFilepath, url, progress, success);
    }

    @Override
    public void LoadImages(String url, ImageView view) {
        TureLoadImage(url, view);
    }

    /**
     *
     * @param url
     * @param callback
     */
    @Override
    public void getStartMediaInfo(String url, final RequestIterface.IStartMediaCallBack callback) {
        TrueConfigInfomation("", new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                AdModel<StartMediaModel> model = mGson.fromJson(reqeust.toString(),new TypeToken<AdModel<StartMediaModel>>(){}.getType());
                callback.onStartMediaBack(model);
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {

            }
        });
    }

    /**
     * 获取后贴片的视频资源
     * @param url
     * @param callBack
     */
    @Override
    public void getEndMediaInfo(String url, final RequestIterface.IEndMediaCallBack callBack) {
        TrueConfigInfomation(url, new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                AdModel<StartMediaModel> model = mGson.fromJson(reqeust.toString(),new TypeToken<AdModel<StartMediaModel>>(){}.getType());
                callBack.onEndMediaBack(model);
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {
            //TODO   统一处理错误的返回
            }
        });
    }

    @Override
    public void reportInfo(String url, final RequestIterface.IReportInfoCallBack callBack) {
        TrueConfigInfomation(url, new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                callBack.onReportBack(true);
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {
                callBack.onReportBack(false);
            }
        });
    }

    @Override
    public void getImageBitMap(String url, RequestIterface.IImageBitMap callBack) {
        ThregetBitMap(url, callBack);
    }

    private void ThregetBitMap(String url, final RequestIterface.IImageBitMap callBack){
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                callBack.onImageBitMap(response);
            }
        }, 1920, 1080, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO   统一处理错误的返回
            }
        });
        mQueue.add(request);
    }

    /**
     *
     * @param url
     * @param view
     */
    private void TureLoadImage(String url, ImageView view) {
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(view, R.drawable.load_backg, R.drawable.load_backg);
        BitmapCache cache = new BitmapCache();
        ImageLoader loader = new ImageLoader(mQueue, cache);
        loader.get(url, listener);
    }

    private void TrueConfigInfomation(String url, final RequestIterface.ISuccessRequest successRequest, final RequestIterface.IFaileRequest faileRequest) {
        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                successRequest.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                faileRequest.onFailed(error);
            }
        });
        mQueue.add(request);
    }


    private void DownLodResource(final String targetfilepath, final String sourceurl, final RequestIterface.IDownLoadProgress pro, final RequestIterface.IDownLoadSuccess success) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                try {
                    File file = new File(targetfilepath);
                    if (file.exists()) {
                        //对已存在的本地文件做处理
                    }
                    URL urls = new URL(sourceurl);
                    URLConnection urlConnection = urls.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.connect();
                    int contentLength = httpURLConnection.getContentLength();
                    RandomAccessFile accessFile = new RandomAccessFile(targetfilepath, "rwd");
                    byte[] bytes = new byte[1024 * 50];
                    int length = -1;
                    long downsize = 0;
                    InputStream is = httpURLConnection.getInputStream();
                    while ((length = is.read(bytes)) != -1) {
                        accessFile.write(bytes, 0, length);
                        downsize += length;
                        pro.onDownLoadProgress((int) downsize);
                        if (contentLength == downsize) {
                            success.onDownLoadSuccess("success");
                            return "success";
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    private void LoadImgFromGlide(ImageView imageView,String url,Object context){
        if(context instanceof Context) {
            Glide.with((Context) context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }else if(context instanceof Activity){
            Glide.with((Activity) context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }else if(context instanceof Fragment){
            Glide.with((Fragment) context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }else if(context instanceof android.support.v4.app.Fragment){
            Glide.with((android.support.v4.app.Fragment) context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }else if(context instanceof FragmentActivity){
            Glide.with((FragmentActivity) context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }
    }

    private class BitmapCache implements ImageLoader.ImageCache {
        //LruCache对象
        private LruCache<String, Bitmap> lruCache;
        int maxCache = (int) Runtime.getRuntime().maxMemory();
        //设置最大缓存为最大值的八分之一，大于这个值会启动自动回收
        private int max = maxCache / 8;
        public BitmapCache() {
            //初始化 LruCache
            lruCache = new LruCache<String, Bitmap>(max) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }
        @Override
        public Bitmap getBitmap(String url) {
            return lruCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            lruCache.put(url, bitmap);
        }
    }
}
