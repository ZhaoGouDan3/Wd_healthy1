package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/24
 */
public class CategoryBean {
    /**
     * result : [{"amount":0,"collectionNum":1,"commentNum":17,"detail":"窜稀","releaseTime":1663603200000,"sickCircleId":1076,"title":"不鸡丢"},{"amount":0,"collectionNum":23,"commentNum":49,"detail":"1111","releaseTime":1663516800000,"sickCircleId":1072,"title":"111"},{"amount":0,"collectionNum":3,"commentNum":13,"detail":"1111","releaseTime":1663516800000,"sickCircleId":1071,"title":"111"},{"amount":0,"collectionNum":3,"commentNum":11,"detail":"1111","releaseTime":1663257600000,"sickCircleId":1070,"title":"1111"},{"amount":30,"collectionNum":7,"commentNum":2,"detail":"明","releaseTime":1662912000000,"sickCircleId":1058,"title":"摸摸看"}]
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
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
