package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class PayHistoryBean {

    /**
     * result : [{"changeNum":-500,"createTime":1663205671000,"direction":2,"type":12},{"changeNum":-500,"createTime":1663205671000,"direction":2,"type":12},{"changeNum":-500,"createTime":1663205671000,"direction":2,"type":12},{"changeNum":-500,"createTime":1663205671000,"direction":2,"type":12},{"changeNum":-500,"createTime":1663205671000,"direction":2,"type":12}]
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
         * changeNum : -500
         * createTime : 1663205671000
         * direction : 2
         * type : 12
         */

        private int changeNum;
        private long createTime;
        private int direction;
        private int type;

        public int getChangeNum() {
            return changeNum;
        }

        public void setChangeNum(int changeNum) {
            this.changeNum = changeNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
