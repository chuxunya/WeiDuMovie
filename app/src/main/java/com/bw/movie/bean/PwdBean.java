package com.bw.movie.bean;
/**
 *@describe(描述)：PwdBean
 *@data（日期）: 2019/12/7
 *@time（时间）: 13:40
 *@author（作者）: xin
 **/
public class PwdBean {

    /**
     * message : 密码修改成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "PwdBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
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
