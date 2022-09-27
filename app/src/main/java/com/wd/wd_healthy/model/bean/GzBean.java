package com.wd.wd_healthy.model.bean;

import java.util.List;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/17
 */
public class GzBean {

    /**
     * result : [{"badNum":0,"departmentId":4,"departmentName":"眼科 ","doctorId":51,"id":2066,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image3.jpg","inauguralHospital":"河南驻马店","jobTitle":"主治医师","name":"李灵恩","number":5,"praise":"100.00%","praiseNum":1},{"badNum":1,"departmentId":7,"departmentName":"内科 ","doctorId":47,"id":2065,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image6.jpg","inauguralHospital":"阿里巴巴","jobTitle":"主治医师","name":"你猜","number":31,"praise":"83.33%","praiseNum":5},{"badNum":0,"departmentId":7,"departmentName":"内科 ","doctorId":18,"id":2064,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image5.jpg","inauguralHospital":"八维医院","jobTitle":"主治医师","name":"何鑫雨","number":172,"praise":"0.00%","praiseNum":0}]
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
         * badNum : 0
         * departmentId : 4
         * departmentName : 眼科
         * doctorId : 51
         * id : 2066
         * imagePic : http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image3.jpg
         * inauguralHospital : 河南驻马店
         * jobTitle : 主治医师
         * name : 李灵恩
         * number : 5
         * praise : 100.00%
         * praiseNum : 1
         */

        private int badNum;
        private int departmentId;
        private String departmentName;
        private int doctorId;
        private int id;
        private String imagePic;
        private String inauguralHospital;
        private String jobTitle;
        private String name;
        private int number;
        private String praise;
        private int praiseNum;

        public int getBadNum() {
            return badNum;
        }

        public void setBadNum(int badNum) {
            this.badNum = badNum;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }
    }
}
