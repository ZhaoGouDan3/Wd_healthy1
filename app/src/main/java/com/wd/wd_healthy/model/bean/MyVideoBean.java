package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class MyVideoBean {

    /**
     * result : [{"createTime":1657262260000,"duration":95,"id":49,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek1.mp4","title":"小儿贫血的检查方法有哪些","videoId":1},{"createTime":1657262263000,"duration":98,"id":50,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek2.mp4","title":"儿童错颌畸形如何预防","videoId":2},{"createTime":1657262265000,"duration":165,"id":51,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek3.mp4","title":"小儿长期不爱吃饭是怎么回事","videoId":3},{"createTime":1657262268000,"duration":128,"id":52,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek4.mp4","title":"新生儿黄疸能预防吗","videoId":4},{"createTime":1657262270000,"duration":65,"id":53,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek5.mp4","title":"儿童肥胖会给孩子带来哪些代谢上的影响","videoId":5},{"createTime":1657262281000,"duration":75,"id":54,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek6.mp4","title":"小儿发热如何正确使用退烧药","videoId":6},{"createTime":1657262295000,"duration":59,"id":55,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek7.mp4","title":"智力低下的临床表现","videoId":7},{"createTime":1657262297000,"duration":100,"id":56,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek8.mp4","title":"哪些食物可以促进孩子长高","videoId":8}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * createTime : 1657262260000
         * duration : 95
         * id : 49
         * originalUrl : http://172.17.8.100/video/health/original/ek/ek1.mp4
         * title : 小儿贫血的检查方法有哪些
         * videoId : 1
         */

        private long createTime;
        private int duration;
        private int id;
        private String originalUrl;
        private String title;
        private int videoId;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginalUrl() {
            return originalUrl;
        }

        public void setOriginalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }
    }
}
