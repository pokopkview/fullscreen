package ad.joyplus.com.retorfitokhttp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by UPC on 2016/7/13.
 */
public class SingleResourceModel implements Serializable {


    /**
     * code : 0
     * msg : ok
     * data : {"id":"2","name":"树大招风","res":"\\ziyan\\a.mp4","target_res":"www.adjoy.com/chk_src/db06c78d1e24cf708a14/8b85881d9f371faef2c532e84deff53a/ece213a1850d41aeb9f4134f58813d65/96b510bca2592fc5db2f411603fa56e4/e6180d6a007ad544a90b0ed75706acf0/a.mp4","level":"4","tag":["4"],"part":"2","channel":"社交","production_date":"2016-07-13","author":"宏伟","series":"tvb","weight":"5","mem":"树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风","watched":"9999","mark":"10","other_recommend":"1,3","exclusive":"0","vip":"1","director":"四万说车","major_role":"四万","long_time":"900000","verify_status":"2","status":"0","description":"树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/b82cd2f10dcd3ece44b7201aec220235.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/b7b2d02c07d65788865db3e48fe77483.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"},"episode":1,"now_episode":1,"collected":2,"other_recommendations":[{"id":"1","name":"自媒-四万-爱车","icon":"{\"240x340\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/dd61da69256789fd49911ac96f2092c3.png\",\"640x380\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/eb0a1bc30046941e6815546ef6185d58.png\",\"210x320\":\"\",\"147x224\":\"\"}","exclusive":"1","vip":"1","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"},"type":["1","1"]},{"id":"3","name":"carmodel","exclusive":"1","vip":"1","imgUrl":{"240x340":"www.adjoy.com","640x380":"www.adjoy.com/img/upload/icon/2016/07/18/1c35faa64f4d17b8fc2d7674cc49e408.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com/img/upload/icon/2016/07/18/97f09e0af212f748f330b9b1e410d6c9.png"},"type":["1","1"]}],"type":["0","1"]}
     */

    private int code;
    private String msg;
    /**
     * id : 2
     * name : 树大招风
     * res : \ziyan\a.mp4
     * target_res : www.adjoy.com/chk_src/db06c78d1e24cf708a14/8b85881d9f371faef2c532e84deff53a/ece213a1850d41aeb9f4134f58813d65/96b510bca2592fc5db2f411603fa56e4/e6180d6a007ad544a90b0ed75706acf0/a.mp4
     * level : 4
     * tag : ["4"]
     * part : 2
     * channel : 社交
     * production_date : 2016-07-13
     * author : 宏伟
     * series : tvb
     * weight : 5
     * mem : 树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风
     * watched : 9999
     * mark : 10
     * other_recommend : 1,3
     * exclusive : 0
     * vip : 1
     * director : 四万说车
     * major_role : 四万
     * long_time : 900000
     * verify_status : 2
     * status : 0
     * description : 树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风树大招风
     * imgUrl : {"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/b82cd2f10dcd3ece44b7201aec220235.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/b7b2d02c07d65788865db3e48fe77483.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"}
     * episode : 1
     * now_episode : 1
     * collected : 2
     * other_recommendations : [{"id":"1","name":"自媒-四万-爱车","icon":"{\"240x340\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/dd61da69256789fd49911ac96f2092c3.png\",\"640x380\":\"\\/img\\/upload\\/icon\\/2016\\/07\\/13\\/eb0a1bc30046941e6815546ef6185d58.png\",\"210x320\":\"\",\"147x224\":\"\"}","exclusive":"1","vip":"1","imgUrl":{"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"},"type":["1","1"]},{"id":"3","name":"carmodel","exclusive":"1","vip":"1","imgUrl":{"240x340":"www.adjoy.com","640x380":"www.adjoy.com/img/upload/icon/2016/07/18/1c35faa64f4d17b8fc2d7674cc49e408.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com/img/upload/icon/2016/07/18/97f09e0af212f748f330b9b1e410d6c9.png"},"type":["1","1"]}]
     * type : ["0","1"]
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

    public static class DataEntity implements Serializable {
        private String id;
        private String name;
        private String res;
        private String target_res;
        private String level;
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
        private String director;
        private String major_role;
        private String long_time;
        private String verify_status;
        private String status;
        private String description;
        /**
         * 240x340 : www.adjoy.com/img/upload/icon/2016/07/13/b82cd2f10dcd3ece44b7201aec220235.png
         * 640x380 : www.adjoy.com/img/upload/icon/2016/07/13/b7b2d02c07d65788865db3e48fe77483.png
         * 210x320 : www.adjoy.com
         * 147x224 : www.adjoy.com
         */

        private ImgUrlEntity imgUrl;
        private int episode;
        private int now_episode;
        private int collected;
        private List<String> tag;
        /**
         * id : 1
         * name : 自媒-四万-爱车
         * icon : {"240x340":"\/img\/upload\/icon\/2016\/07\/13\/dd61da69256789fd49911ac96f2092c3.png","640x380":"\/img\/upload\/icon\/2016\/07\/13\/eb0a1bc30046941e6815546ef6185d58.png","210x320":"","147x224":""}
         * exclusive : 1
         * vip : 1
         * imgUrl : {"240x340":"www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png","640x380":"www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png","210x320":"www.adjoy.com","147x224":"www.adjoy.com"}
         * type : ["1","1"]
         */

        private List<OtherRecommendationsEntity> other_recommendations;
        private List<String> type;
        private List<AllSeriesEntity> all_series;
        private int played_time;

        public int getPlayed_time() {
            return played_time;
        }

        public void setPlayed_time(int played_time) {
            this.played_time = played_time;
        }

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

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getMajor_role() {
            return major_role;
        }

        public void setMajor_role(String major_role) {
            this.major_role = major_role;
        }

        public String getLong_time() {
            return long_time;
        }

        public void setLong_time(String long_time) {
            this.long_time = long_time;
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

        public List<OtherRecommendationsEntity> getOther_recommendations() {
            return other_recommendations;
        }

        public void setOther_recommendations(List<OtherRecommendationsEntity> other_recommendations) {
            this.other_recommendations = other_recommendations;
        }

        public List<String> getType() {
            return type;
        }
        public List<AllSeriesEntity> getAll_series() {
            return all_series;
        }

        public void setAll_series(List<AllSeriesEntity> all_series) {
            this.all_series = all_series;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        public static class AllSeriesEntity implements Serializable {
            private String series;
            private String value;

            public String getSeries() {
                return series;
            }

            public void setSeries(String series) {
                this.series = series;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
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

        public static class OtherRecommendationsEntity implements Serializable {
            private String id;
            private String name;
            private String icon;
            private String exclusive;
            private String vip;
            /**
             * 240x340 : www.adjoy.com/img/upload/icon/2016/07/13/dd61da69256789fd49911ac96f2092c3.png
             * 640x380 : www.adjoy.com/img/upload/icon/2016/07/13/eb0a1bc30046941e6815546ef6185d58.png
             * 210x320 : www.adjoy.com
             * 147x224 : www.adjoy.com
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

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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
}
