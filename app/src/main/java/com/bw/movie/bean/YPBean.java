package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/1
 *@Time:19:31
 *@Description:写评论
 **/
public class YPBean {
    /**
     * message : 评论成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "YPBean{" +
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
