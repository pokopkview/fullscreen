package ad.joyplus.com.myapplication.network;

/**
 * Created by UPC on 2016/8/29.
 */
public class RequestIterface {
    public interface ISuccessRequest{
        void onSuccess(Object reqeust);
    }
    public interface IFaileRequest{
        void onFailed(Object request);
    }
    public interface IDownLoadSuccess{
        void onDownLoadSuccess(String msg);
    }
    public interface IDownLoadProgress{
        void onDownLoadProgress(int progress);
    }
    public interface IModelCallBack<T>{
        void onConfigModelBack(T t);
    }
}
