package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/6
 *@Time:13:49
 *@Description:上传头像
 **/
public class HeadBean {
    /**
     * headPath : http://172.17.8.100/images/movie/head_pic/2019-12-06/20191206134758.png
     * message : 上传成功
     * status : 0000
     */

    private String headPath;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "HeadBean{" +
                "headPath='" + headPath + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
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
