package com.wd.wd_healthy.model.bean;

/**
 * <p>Wd_healthy</p>
 * <p>包名:com.wd.wd_healthy.model.bean</p>
 *
 * @author 赵某某
 * @date 2022/9/22
 */
public class ZxNowBean {

    /**
     * doctorUserName : YOW1HSqsm5TMUnnkj45qHXwRdM/wkXO74bwi+dYHqJ+7Ou01jJSLMPygkbq/kGVU5sZf44IaZ8AJ00EuXfZiNG7co89x3ASqYFnPtBbSpYhGPlodB3lOrDuELJcCHwnvIctP9VPKO5hJpS3AnODC6Lm3wIxoOwcUgX7xqfVPmJA=
     * message : 查询成功
     * status : 0000
     */

    private String doctorUserName;
    private String message;
    private String status;

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
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
}
