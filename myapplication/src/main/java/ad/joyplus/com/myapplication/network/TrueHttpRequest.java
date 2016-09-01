package ad.joyplus.com.myapplication.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import ad.joyplus.com.myapplication.R;
import ad.joyplus.com.myapplication.entity.ConfigModel;

/**
 * Created by UPC on 2016/8/29.
 */
public class TrueHttpRequest implements IRequest{
    private RequestQueue mQueue;
    private Gson mGson;


    public TrueHttpRequest(Context context){
        mQueue = Volley.newRequestQueue(context);
        mGson = new Gson();
    }
    /**
     * 获取配置信息的方法
     * @param url
     */
    @Override
    public void getConfigInfo(String url, final RequestIterface.IModelCallBack<ConfigModel> callBack) {
        TrueConfigInfomation(url, new RequestIterface.ISuccessRequest() {
            @Override
            public void onSuccess(Object reqeust) {
                callBack.onConfigModelBack(mGson.fromJson(reqeust.toString(),ConfigModel.class));
            }
        }, new RequestIterface.IFaileRequest() {
            @Override
            public void onFailed(Object request) {
                Log.e("HttpError",request.toString());
            }
        });
    }




    @Override
    public void DownLoadFiles(String targetFilepath, String url, RequestIterface.IDownLoadProgress progress, RequestIterface.IDownLoadSuccess success) {
        DownLodResource(targetFilepath, url, progress, success);
    }

    @Override
    public void LoadImages(String url, ImageView view) {
        TureLoadImage(url,view);
    }

    @Override
    public void getStartMediaInfo(String url, RequestIterface.ISuccessRequest successRequest, RequestIterface.IFaileRequest faileRequest) {

    }

    private void TureLoadImage(String url,ImageView view){
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(view, R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        BitmapCache cache = new BitmapCache();
        ImageLoader loader = new ImageLoader(mQueue,cache);
        loader.get(url,listener);
    }

    private ConfigModel TrueConfigInfomation(String url, final RequestIterface.ISuccessRequest successRequest, final RequestIterface.IFaileRequest faileRequest){
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
        return null;
    }


    private void DownLodResource(final String targetfilepath, final String sourceurl,final RequestIterface.IDownLoadProgress pro, final RequestIterface.IDownLoadSuccess success){
        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... params) {
                try {
                    File file = new File(targetfilepath);
                    if(file.exists()){
                    //对已存在的本地文件做处理
                    }
                    URL urls = new URL(sourceurl);
                    URLConnection urlConnection = urls.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.connect();
                    int contentLength = httpURLConnection.getContentLength();
                    RandomAccessFile accessFile = new RandomAccessFile(targetfilepath,"rwd");
                    byte [] bytes = new byte[1024*50];
                    int length = -1;
                    long downsize = 0;
                    InputStream is = httpURLConnection.getInputStream();
                    while((length = is.read(bytes)) != -1){
                        accessFile.write(bytes,0, length);
                        downsize +=length;
                        pro.onDownLoadProgress((int) downsize);
                        if(contentLength == downsize){
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
    private class BitmapCache implements ImageLoader.ImageCache {
        //LruCache对象
        private LruCache<String, Bitmap> lruCache ;
        int maxCache = (int) Runtime.getRuntime().maxMemory();
        //设置最大缓存为最大值的八分之一，大于这个值会启动自动回收
        private int max = maxCache / 8;

        public BitmapCache(){
            //初始化 LruCache
            lruCache = new LruCache<String, Bitmap>(max){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getHeight();
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
