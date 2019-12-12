package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/6
 *@Time:19:47
 *@Description:意见反馈
 **/
public class FKBean {
    /**
     * message : 反馈成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "FKBean{" +
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
