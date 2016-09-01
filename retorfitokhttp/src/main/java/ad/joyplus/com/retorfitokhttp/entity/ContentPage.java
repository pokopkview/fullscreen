package ad.joyplus.com.retorfitokhttp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by UPC on 2016/6/21.
 */
public class ContentPage implements Serializable {

    /**
     * code : 0
     * msg : ok
     * data : {"id":"1","name":"自媒-四万-爱车","res":"\\ziyan\\1000mail.mp4","target_res":"www.adjoy.com/chk_src\\1000mail\\2016-07-13\\cctv\\car_play\\1000mail.mp4","level":"4","tag":["汽车","发动机"],"icon":"{\"240x340\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/dd61da69256789fd49911ac96f2092c3.png\",\"640x380\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/eb0a1bc30046941e6815546ef6185d58.png\",\"210x320\":\"\",\"147x224\":\"\"}","part":"1","channel":"1000mail","production_date":"2016-07-13","author":"cctv","series":"car_play","weight":"5","mem":"测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试","watched":"9999","mark":"10","other_recommend":"","exclusive":"1","vip":"1","verify_status":"2","status":"0","description":"测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"},"episode":1,"now_episode":1,"collected":2,"other_recommendations":[],"type":["1","1"]}
     */

    private int code;
    private String msg;
    /**
     * id : 1
     * name : 自媒-四万-爱车
     * res : \ziyan\1000mail.mp4
     * target_res : www.adjoy.com/chk_src\1000mail\2016-07-13\cctv\car_play\1000mail.mp4
     * level : 4
     * tag : ["汽车","发动机"]
     * icon : {"240x340":"\/img\/upload\/icon\/2016\/07\/13\/dd61da69256789fd49911ac96f2092c3.png","640x380":"\/img\/upload\/icon\/2016\/07\/13\/eb0a1bc30046941e6815546ef6185d58.png","210x320":"","147x224":""}
     * part : 1
     * channel : 1000mail
     * production_date : 2016-07-13
     * author : cctv
     * series : car_play
     * weight : 5
     * mem : 测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试
     * watched : 9999
     * mark : 10
     * other_recommend :
     * exclusive : 1
     * vip : 1
     * verify_status : 2
     * status : 0
     * description : 测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试
     * imgUrl : {"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"}
     * episode : 1
     * now_episode : 1
     * collected : 2
     * other_recommendations : []
     * type : ["1","1"]
     */

    private DataEntity data;

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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String id;
        private String name;
        private String res;
        private String target_res;
        private String level;
        private String icon;
        private String part;
        private String channel;
        private String production_date;
        private String author;
        private String series;
        private String weight;
        private String mem;
        private String watched;
        private String mark;
        private String other_recommend;
        private String exclusive;
        private String vip;
        private String verify_status;
        private String status;
        private String description;
        /**
         * 240x340 : www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png
         * 640x380 : www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png
         * 210x320 : www.adjoy.com
         * 147x224 : www.adjoy.com
         */

        private ImgUrlEntity imgUrl;
        private int episode;
        private int now_episode;
        private int collected;
        private List<String> tag;
        private List<?> other_recommendations;
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

        public String getRes() {
            return res;
        }

        public void setRes(String res) {
            this.res = res;
        }

        public String getTarget_res() {
            return target_res;
        }

        public void setTarget_res(String target_res) {
            this.target_res = target_res;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPart() {
            return part;
        }

        public void setPart(String part) {
            this.part = part;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getProduction_date() {
            return production_date;
        }

        public void setProduction_date(String production_date) {
            this.production_date = production_date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getMem() {
            return mem;
        }

        public void setMem(String mem) {
            this.mem = mem;
        }

        public String getWatched() {
            return watched;
        }

        public void setWatched(String watched) {
            this.watched = watched;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getOther_recommend() {
            return other_recommend;
        }

        public void setOther_recommend(String other_recommend) {
            this.other_recommend = other_recommend;
        }

        public String getExclusive() {
            return exclusive;
        }

        public void setExclusive(String exclusive) {
            this.exclusive = exclusive;
        }

        public String getVip() {
            return vip;
        }

        public void setVip(String vip) {
            this.vip = vip;
        }

        public String getVerify_status() {
            return verify_status;
        }

        public void setVerify_status(String verify_status) {
            this.verify_status = verify_status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ImgUrlEntity getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(ImgUrlEntity imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getEpisode() {
            return episode;
        }

        public void setEpisode(int episode) {
            this.episode = episode;
        }

        public int getNow_episode() {
            return now_episode;
        }

        public void setNow_episode(int now_episode) {
            this.now_episode = now_episode;
        }

        public int getCollected() {
            return collected;
        }

        public void setCollected(int collected) {
            this.collected = collected;
        }

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }

        public List<?> getOther_recommendations() {
            return other_recommendations;
        }

        public void setOther_recommendations(List<?> other_recommendations) {
            this.other_recommendations = other_recommendations;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        public static class ImgUrlEntity {
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
