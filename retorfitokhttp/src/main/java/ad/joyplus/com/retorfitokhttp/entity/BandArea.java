package ad.joyplus.com.retorfitokhttp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by UPC on 2016/6/22.
 * 专区页面数据模型
 */
public class BandArea implements Serializable {

    /**
     * code : 0
     * msg : ok
     * data : [{"id":"1","name":"car_play","mark":"9","watched":"123","mem":"四万四万四万四万说车说车说车说车说车说车说车","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/f3ded37b5620a172df5e229a9a284707.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/c274c516db8f89642a7e7f0792446711.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/a2aa2a64802bf9287c0497a1745ae944.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/f024d0922e074811f383ab6bf031df62.jpg"},"type":["0","1","1"]},{"id":"2","name":"cctv","mark":"6","watched":"2000","mem":"本田本田本田本田本田本田本田本田本田本田本田本田本田本田本田本田本田本田","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/f4079c57a3be2566ab95243b3723c562.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/762dc44ed92bc738ac1911c207bac4ff.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/d45fac01b774df48c41a7e77210d1bdd.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/e59fc15990c8a56085ffb4d4548e22e9.jpg"},"type":["0","0","1"]},{"id":"3","name":"tvb","mark":"6","watched":"2000","mem":"思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域思域","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/2ac5c5029688cd9068e439cec70605a7.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/b99d989612db901c61fa7c4028a547f5.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/9e7ce4a4994e382ea7f63e6a149a87a3.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/689a027861b161df2c5f1ddf66966b27.jpg"},"type":["0","0","1"]},{"id":"4","name":"四万说车","mark":"6","watched":"2000","mem":"艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7艾瑞泽7","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/e893e697c85c2e07a534b4129b266494.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/e73bd8ca8eb93fb1cb8845a8540574ea.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/9797c6362e7d6be2678d4a188f814265.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/fd5b63d937fbf068a739d3ba8b79bb2d.jpg"},"type":["0","0","1"]},{"id":"5","name":"糗事百科","mark":"6","watched":"2000","mem":"比亚迪比亚迪比亚迪比亚迪比亚迪比亚迪比亚迪比亚迪","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/1efb6e61ac80e685b4eca1af89658f3d.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/3f85e0688865b0ef4b172a1a4847656b.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/fd627320e67436816c46b0b7e6b7b30e.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/aa3ab06d99e7c675b368e28f94a7f7e0.jpg"},"type":["0","0","1"]},{"id":"6","name":"新车评","mark":"6","watched":"2000","mem":"新车评网是中国首个消费者类汽车专业网站，2006年7月成立于深圳，现总部位于广州，内容面向全国。\u201c新车评网\u201d的宗旨是提供中立、专业和真实的汽车资讯，帮助消费者做出最正确的购车选择。","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/8d761486672848c3ac93602dc086301d.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/4f5cd2bcb192b1b3519598c9e6c32280.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/6984256f2a31d57d6817b5d739295d21.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/478703dd5e1e8d72f0c3a89a2a4bfe42.jpg"},"type":["1","1","1"]}]
     */

    private int code;
    private String msg;
    /**
     * id : 1
     * name : car_play
     * mark : 9
     * watched : 123
     * mem : 四万四万四万四万说车说车说车说车说车说车说车
     * imgUrl : {"240x340":"www.adjoy.com/img/upload/icon/2016/08/05/f3ded37b5620a172df5e229a9a284707.jpg","640x380":"www.adjoy.com/img/upload/icon/2016/08/05/c274c516db8f89642a7e7f0792446711.jpg","210x320":"www.adjoy.com/img/upload/icon/2016/08/05/a2aa2a64802bf9287c0497a1745ae944.jpg","147x224":"www.adjoy.com/img/upload/icon/2016/08/05/f024d0922e074811f383ab6bf031df62.jpg"}
     * type : ["0","1","1"]
     */

    private List<DataEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity implements Serializable {
        private String id;
        private String name;
        private String mark;
        private String watched;
        private String mem;
        /**
         * 240x340 : www.adjoy.com/img/upload/icon/2016/08/05/f3ded37b5620a172df5e229a9a284707.jpg
         * 640x380 : www.adjoy.com/img/upload/icon/2016/08/05/c274c516db8f89642a7e7f0792446711.jpg
         * 210x320 : www.adjoy.com/img/upload/icon/2016/08/05/a2aa2a64802bf9287c0497a1745ae944.jpg
         * 147x224 : www.adjoy.com/img/upload/icon/2016/08/05/f024d0922e074811f383ab6bf031df62.jpg
         */

        private ImgUrlEntity imgUrl;
        private List<String> type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getWatched() {
            return watched;
        }

        public void setWatched(String watched) {
            this.watched = watched;
        }

        public String getMem() {
            return mem;
        }

        public void setMem(String mem) {
            this.mem = mem;
        }

        public ImgUrlEntity getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(ImgUrlEntity imgUrl) {
            this.imgUrl = imgUrl;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        public static class ImgUrlEntity implements Serializable {
            private String value240x340;
            private String value640x380;
            private String value210x320;
            private String value147x224;

            public String getValue240x340() {
                return value240x340;
            }

            public void setValue240x340(String value240x340) {
                this.value240x340 = value240x340;
            }

            public String getValue640x380() {
                return value640x380;
            }

            public void setValue640x380(String value640x380) {
                this.value640x380 = value640x380;
            }

            public String getValue210x320() {
                return value210x320;
            }

            public void setValue210x320(String value210x320) {
                this.value210x320 = value210x320;
            }

            public String getValue147x224() {
                return value147x224;
            }

            public void setValue147x224(String value147x224) {
                this.value147x224 = value147x224;
            }
        }
    }
}
