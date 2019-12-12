package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/8
 *@Time:20:15
 *@Description:取消关注电影
 **/
public class QGZMBean {
    /**
     * message : 取消关注成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "QGZMBean{" +
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
