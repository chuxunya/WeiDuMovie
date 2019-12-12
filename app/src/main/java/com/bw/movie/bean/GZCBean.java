package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/9
 *@Time:10:03
 *@Description:影院关注
 **/
public class GZCBean {
    /**
     * message : 关注成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "GZCBean{" +
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
