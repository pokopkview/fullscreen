package ad.joyplus.com.sdkdemos;

/**
 * Created by UPC on 2016/9/8.
 */
public class testMap<T>{


    /**
     * Code : 1
     * VersonCode : 1.0
     * msg : ok
     * data : {"publishID":{"open":"open","startmedia":"startmedia","endmedia":"endmedia"},"baseURL":"987654321","maxSize":"555555555","showcount":"9"}
     */

    private String Code;
    private String VersonCode;
    private String msg;
    /**
     * publishID : {"open":"open","startmedia":"startmedia","endmedia":"endmedia"}
     * baseURL : 987654321
     * maxSize : 555555555
     * showcount : 9
     */

    private T data;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getVersonCode() {
        return VersonCode;
    }

    public void setVersonCode(String VersonCode) {
        this.VersonCode = VersonCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
