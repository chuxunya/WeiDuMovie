package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/9
 *@Time:10:05
 *@Description:取消关注影院
 **/
public class QGZCBean {
    /**
     * message : 取消关注成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "QGZCBean{" +
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
