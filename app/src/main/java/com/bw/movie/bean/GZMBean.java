package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/8
 *@Time:14:20
 *@Description:关注电影
 **/
public class GZMBean {
    /**
     * message : 请先登陆
     * status : 9999
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "GZMBean{" +
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
