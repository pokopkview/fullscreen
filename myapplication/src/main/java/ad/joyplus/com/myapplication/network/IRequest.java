package ad.joyplus.com.myapplication.network;

import android.widget.ImageView;

import ad.joyplus.com.myapplication.entity.ConfigModel;

/**
 * Created by UPC on 2016/8/29.
 */
public interface IRequest {

    void getConfigInfo(String url, RequestIterface.IModelCallBack<ConfigModel> callBack);
    void DownLoadFiles(String targetFilepath, String url, RequestIterface.IDownLoadProgress progress, RequestIterface.IDownLoadSuccess success);
    void LoadImages(String url, ImageView view);
    void getStartMediaInfo(String url,RequestIterface.ISuccessRequest successRequest, RequestIterface.IFaileRequest faileRequest);
}
