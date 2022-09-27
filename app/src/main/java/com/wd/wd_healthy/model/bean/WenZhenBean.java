package com.wd.wd_healthy.model.bean;

public class WenZhenBean {

    /**
     * result : {"department":"皮肤科","departmentId":9,"doctorId":45,"doctorName":"Sky","evaluateStatus":1,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image4.jpg","inquiryTime":1663556776000,"jiGuangPwd":"Th9DYT/yb6IjpDJ5t0F8cHoykU23JCZCe7rv1TgsAY3w9/sLU0IpLqncMwfkbR0hC90U1+K9FQJt92Mxu98xUtPawIbS3LbPWyDCUe8tGapKeac9d0nMsMJYwfRpr1331AqLZZJimyU7orwylSiR9kWh4xbMDOYjYHClR2KjSe0=","jobTitle":"主治医师","recordId":4113,"userName":"2KzIxR2921923336"}
     * message : 查询成功
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
         * department : 皮肤科
         * departmentId : 9
         * doctorId : 45
         * doctorName : Sky
         * evaluateStatus : 1
         * imagePic : http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image4.jpg
         * inquiryTime : 1663556776000
         * jiGuangPwd : Th9DYT/yb6IjpDJ5t0F8cHoykU23JCZCe7rv1TgsAY3w9/sLU0IpLqncMwfkbR0hC90U1+K9FQJt92Mxu98xUtPawIbS3LbPWyDCUe8tGapKeac9d0nMsMJYwfRpr1331AqLZZJimyU7orwylSiR9kWh4xbMDOYjYHClR2KjSe0=
         * jobTitle : 主治医师
         * recordId : 4113
         * userName : 2KzIxR2921923336
         */

        private String department;
        private int departmentId;
        private int doctorId;
        private String doctorName;
        private int evaluateStatus;
        private String imagePic;
        private long inquiryTime;
        private String jiGuangPwd;
        private String jobTitle;
        private int recordId;
        private String userName;

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public int getEvaluateStatus() {
            return evaluateStatus;
        }

        public void setEvaluateStatus(int evaluateStatus) {
            this.evaluateStatus = evaluateStatus;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
