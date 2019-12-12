package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/7
 *@Time:23:16
 *@Description:影院评论
 **/
public class YYPLBean {
    /**
     * message : 评论成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "YYPLBean{" +
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
