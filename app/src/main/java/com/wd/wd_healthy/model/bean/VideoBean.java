package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/24
 */
public class VideoBean {

    /**
     * result : [{"abstracts":"可能是忘了忌口，这几种食物要少吃","buyNum":30,"categoryId":2,"duration":85,"id":9,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs1.mp4","price":150,"shearUrl":"http://mobile.bwstudent.com/video/health/cut/cs/cs1.mp4","title":"春季孩子咳嗽为何老不好？","whetherBuy":2,"whetherCollection":2},{"abstracts":"能抠吗？","buyNum":23,"categoryId":2,"duration":68,"id":10,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs2.mp4","price":88,"shearUrl":"http://mobile.bwstudent.com/video/health/cut/cs/cs2.mp4","title":"肚脐眼里的\u201c泥\u201d到底是什么？","whetherBuy":2,"whetherCollection":2},{"abstracts":"这样烧的水不仅不能喝，还对人体有害","buyNum":19,"categoryId":2,"duration":78,"id":11,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs3.mp4","price":70,"shearUrl":"http://mobile.bwstudent.com/video/health/cut/cs/cs3.mp4","title":"多喝热水真的好吗？","whetherBuy":2,"whetherCollection":2},{"abstracts":"原来被骗了这么多年","buyNum":14,"categoryId":2,"duration":52,"id":12,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs4.mp4","price":69,"shearUrl":"http://mobile.bwstudent.com/video/health/cut/cs/cs4.mp4","title":"感冒发烧多盖被子，这种做法真的正确吗？","whetherBuy":2,"whetherCollection":2},{"abstracts":"快试试吧","buyNum":9,"categoryId":2,"duration":75,"id":14,"originalUrl":"http://172.17.8.100/video/health/original/cs/cs6.mp4","price":88,"shearUrl":"http://mobile.bwstudent.com/video/health/cut/cs/cs6.mp4","title":"脚上长了鸡眼太疼了，教你去除鸡眼最简单的3个方法","whetherBuy":2,"whetherCollection":2}]
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
         * abstracts : 可能是忘了忌口，这几种食物要少吃
         * buyNum : 30
         * categoryId : 2
         * duration : 85
         * id : 9
         * originalUrl : http://172.17.8.100/video/health/original/cs/cs1.mp4
         * price : 150
         * shearUrl : http://mobile.bwstudent.com/video/health/cut/cs/cs1.mp4
         * title : 春季孩子咳嗽为何老不好？
         * whetherBuy : 2
         * whetherCollection : 2
         */

        private String abstracts;
        private int buyNum;
        private int categoryId;
        private int duration;
        private int id;
        private String originalUrl;
        private int price;
        private String shearUrl;
        private String title;
        private int whetherBuy;
        private int whetherCollection;

        public String getAbstracts() {
            return abstracts;
        }

        public void setAbstracts(String abstracts) {
            this.abstracts = abstracts;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getShearUrl() {
            return shearUrl;
        }

        public void setShearUrl(String shearUrl) {
            this.shearUrl = shearUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWhetherBuy() {
            return whetherBuy;
        }

        public void setWhetherBuy(int whetherBuy) {
            this.whetherBuy = whetherBuy;
        }

        public int getWhetherCollection() {
            return whetherCollection;
        }

        public void setWhetherCollection(int whetherCollection) {
            this.whetherCollection = whetherCollection;
        }
    }
}
