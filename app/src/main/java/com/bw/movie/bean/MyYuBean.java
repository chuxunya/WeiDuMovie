package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/6
 *@Time:21:27
 *@Description:查询我的预约
 **/
public class MyYuBean {
    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg","movieId":1,"name":"我不是药神","releaseTime":1530720000000,"wantSeeNum":20}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "MyYuBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * imageUrl : http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg
         * movieId : 1
         * name : 我不是药神
         * releaseTime : 1530720000000
         * wantSeeNum : 20
         */

        private String imageUrl;
        private int movieId;
        private String name;
        private long releaseTime;
        private int wantSeeNum;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "imageUrl='" + imageUrl + '\'' +
                    ", movieId=" + movieId +
                    ", name='" + name + '\'' +
                    ", releaseTime=" + releaseTime +
                    ", wantSeeNum=" + wantSeeNum +
                    '}';
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getWantSeeNum() {
            return wantSeeNum;
        }

        public void setWantSeeNum(int wantSeeNum) {
            this.wantSeeNum = wantSeeNum;
        }
    }
}
