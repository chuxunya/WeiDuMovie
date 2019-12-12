package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/11
 *@Time:16:34
 *@Description:注册bean
 **/
public class RegisterBean {
    /**
     * message : 验证码已过期
     * status : 1001
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "RegisterBean{" +
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
