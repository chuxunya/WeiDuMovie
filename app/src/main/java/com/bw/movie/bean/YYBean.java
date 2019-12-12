package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/8
 *@Time:20:17
 *@Description:预约
 **/
public class YYBean {
    /**
     * message : 预约成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "YYBean{" +
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
