package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/11
 *@Time:16:33
 *@Description:验证码Bean
 **/
public class CodeBean {
    /**
     * message : 发送成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "CodeBean{" +
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
