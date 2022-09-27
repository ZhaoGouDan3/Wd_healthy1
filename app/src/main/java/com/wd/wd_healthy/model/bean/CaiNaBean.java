package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/16
 */
public class CaiNaBean {
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
         * id : 1
         * plateId : 1
         * releaseTime : 1555035309000
         * source : @weidu
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1slZcBvEg1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1YYVOBvYT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1mRDSB7xT1RCvBVdK
         * title : 春季预防三高，预防心脑血管疾病，不得不提到的三个“笋”子！
         */

        private int releaseUserId;
        private String releaseUserNickName;
        private String releaseUserHeadPic;
        private String title;
        private String disease;
        private String adoptTime;
        private long content;

        public int getReleaseUserId() {
            return releaseUserId;
        }

        public void setReleaseUserId(int releaseUserId) {
            this.releaseUserId = releaseUserId;
        }

        public String getReleaseUserNickName() {
            return releaseUserNickName;
        }

        public void setReleaseUserNickName(String releaseUserNickName) {
            this.releaseUserNickName = releaseUserNickName;
        }

        public String getReleaseUserHeadPic() {
            return releaseUserHeadPic;
        }

        public void setReleaseUserHeadPic(String releaseUserHeadPic) {
            this.releaseUserHeadPic = releaseUserHeadPic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public String getAdoptTime() {
            return adoptTime;
        }

        public void setAdoptTime(String adoptTime) {
            this.adoptTime = adoptTime;
        }

        public long getContent() {
            return content;
        }

        public void setContent(long content) {
            this.content = content;
        }
    }
}
