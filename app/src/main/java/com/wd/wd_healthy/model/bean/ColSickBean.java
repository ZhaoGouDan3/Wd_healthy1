package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class ColSickBean {

    /**
     * result : [{"collectionNum":1,"commentNum":0,"createTime":1663312039000,"disease":"猩红热","id":611,"sickCircleId":1051,"title":"222"},{"collectionNum":1,"commentNum":0,"createTime":1663312025000,"disease":"高脂蛋白血症","id":610,"sickCircleId":1054,"title":"好嘞"},{"collectionNum":1,"commentNum":0,"createTime":1663312015000,"disease":"高血压","id":609,"sickCircleId":1058,"title":"摸摸看"}]
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
         * collectionNum : 1
         * commentNum : 0
         * createTime : 1663312039000
         * disease : 猩红热
         * id : 611
         * sickCircleId : 1051
         * title : 222
         */

        private int collectionNum;
        private int commentNum;
        private long createTime;
        private String disease;
        private int id;
        private int sickCircleId;
        private String title;

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
