package com.wd.wd_healthy.model.bean;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/15
 */
public class DangAnBean {

    /**
     * result : {"diseaseBefore":"既往史","diseaseMain":"头疼","diseaseNow":"现病史","id":3,"picture":"http://172.17.8.100/images/health/user/archives/2019-04-03/20190403120155.jpg,http://172.17.8.100/images/health/user/archives/2019-04-03/20190403120155.jpg","treatmentEndTime":1554220800000,"treatmentHospitalRecent":"治疗医院","treatmentProcess":"治疗过程","treatmentStartTime":1522684800000,"userId":1}
     * message : 用户档案查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * diseaseBefore : 既往史
         * diseaseMain : 头疼
         * diseaseNow : 现病史
         * id : 3
         * picture : http://172.17.8.100/images/health/user/archives/2019-04-03/20190403120155.jpg,http://172.17.8.100/images/health/user/archives/2019-04-03/20190403120155.jpg
         * treatmentEndTime : 1554220800000
         * treatmentHospitalRecent : 治疗医院
         * treatmentProcess : 治疗过程
         * treatmentStartTime : 1522684800000
         * userId : 1
         */

        private String diseaseBefore;
        private String diseaseMain;
        private String diseaseNow;
        private int id;
        private String picture;
        private long treatmentEndTime;
        private String treatmentHospitalRecent;
        private String treatmentProcess;
        private long treatmentStartTime;
        private int userId;

        public String getDiseaseBefore() {
            return diseaseBefore;
        }

        public void setDiseaseBefore(String diseaseBefore) {
            this.diseaseBefore = diseaseBefore;
        }

        public String getDiseaseMain() {
            return diseaseMain;
        }

        public void setDiseaseMain(String diseaseMain) {
            this.diseaseMain = diseaseMain;
        }

        public String getDiseaseNow() {
            return diseaseNow;
        }

        public void setDiseaseNow(String diseaseNow) {
            this.diseaseNow = diseaseNow;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospitalRecent() {
            return treatmentHospitalRecent;
        }

        public void setTreatmentHospitalRecent(String treatmentHospitalRecent) {
            this.treatmentHospitalRecent = treatmentHospitalRecent;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
