package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class ColZxBean {

    /**
     * result : [{"createTime":1663311962000,"id":1089,"infoId":3,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1hYEOB__T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1ezYSBCDT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1JzASBXdT1RCvBVdK","title":"这4个错误的姿势，最容易引起脊柱侧弯！多数人都中枪了"},{"createTime":1663311959000,"id":1088,"infoId":1,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1slZcBvEg1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1YYVOBvYT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1mRDSB7xT1RCvBVdK","title":"春季预防三高，预防心脑血管疾病，不得不提到的三个\u201c笋\u201d子！"}]
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
         * createTime : 1663311962000
         * id : 1089
         * infoId : 3
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1hYEOB__T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1ezYSBCDT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1JzASBXdT1RCvBVdK
         * title : 这4个错误的姿势，最容易引起脊柱侧弯！多数人都中枪了
         */

        private long createTime;
        private int id;
        private int infoId;
        private String thumbnail;
        private String title;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
