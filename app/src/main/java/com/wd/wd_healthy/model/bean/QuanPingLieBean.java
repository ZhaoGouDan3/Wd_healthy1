package com.wd.wd_healthy.model.bean;

import java.util.List;

public class QuanPingLieBean {

    /**
     * result : [{"commentId":1352,"commentTime":1663592174000,"commentUserId":1,"content":"耶斯莫拉","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_4.jpg","nickName":"uH_DUOPH","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1347,"commentTime":1663589801000,"commentUserId":234,"content":"44","headPic":"http://10.59.9.18/images/health/user/head_pic/default/default_head_4.jpg","nickName":"zy_QBAVA","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1346,"commentTime":1663589088000,"commentUserId":234,"content":"GGA","headPic":"http://10.59.9.18/images/health/user/head_pic/default/default_head_4.jpg","nickName":"zy_QBAVA","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1340,"commentTime":1663572906000,"commentUserId":12,"content":"iuguigui","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_5.jpg","nickName":"dI_NQYLE","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1339,"commentTime":1663571563000,"commentUserId":11,"content":"恶心","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1338,"commentTime":1663571556000,"commentUserId":11,"content":"实在是","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1337,"commentTime":1663571464000,"commentUserId":11,"content":"啊啊啊","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":1,"whetherDoctor":2},{"commentId":1336,"commentTime":1663570974000,"commentUserId":11,"content":"一爱谁谁斗殴碍事的","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1335,"commentTime":1663570873000,"commentUserId":11,"content":"啊互怼瓯海苏","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":1334,"commentTime":1663570865000,"commentUserId":11,"content":"嘻嘻嘻","headPic":"http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_1.jpg","nickName":"oN_RLIXU","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2}]
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
         * commentId : 1352
         * commentTime : 1663592174000
         * commentUserId : 1
         * content : 耶斯莫拉
         * headPic : http://mobile.bwstudent.com/images/health/user/head_pic/default/default_head_4.jpg
         * nickName : uH_DUOPH
         * opinion : 0
         * opposeNum : 0
         * supportNum : 0
         * whetherDoctor : 2
         */

        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String content;
        private String headPic;
        private String nickName;
        private int opinion;
        private int opposeNum;
        private int supportNum;
        private int whetherDoctor;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getOpinion() {
            return opinion;
        }

        public void setOpinion(int opinion) {
            this.opinion = opinion;
        }

        public int getOpposeNum() {
            return opposeNum;
        }

        public void setOpposeNum(int opposeNum) {
            this.opposeNum = opposeNum;
        }

        public int getSupportNum() {
            return supportNum;
        }

        public void setSupportNum(int supportNum) {
            this.supportNum = supportNum;
        }

        public int getWhetherDoctor() {
            return whetherDoctor;
        }

        public void setWhetherDoctor(int whetherDoctor) {
            this.whetherDoctor = whetherDoctor;
        }
    }
}
