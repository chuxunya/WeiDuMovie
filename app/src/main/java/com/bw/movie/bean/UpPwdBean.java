package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/12
 *@Time:14:08
 *@Description:修改密码bean
 **/
public class UpPwdBean {
    /**
     * message : 密码修改成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "UpPwdBean{" +
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
