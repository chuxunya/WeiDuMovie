package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:14:21
 *@Description:看过的电影
 **/
public class LookedBean {

    /**
     * result : [{"beginTime":37800000,"cinemaId":9,"endTime":42900000,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","recordId":5320,"whetherComment":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "LookedBean{" +
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
         * beginTime : 37800000
         * cinemaId : 9
         * endTime : 42900000
         * imageUrl : http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * movieName : 少年的你
         * recordId : 5320
         * whetherComment : 2
         */

        private int beginTime;
        private int cinemaId;
        private int endTime;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int recordId;
        private int whetherComment;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "beginTime=" + beginTime +
                    ", cinemaId=" + cinemaId +
                    ", endTime=" + endTime +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieId=" + movieId +
                    ", movieName='" + movieName + '\'' +
                    ", recordId=" + recordId +
                    ", whetherComment=" + whetherComment +
                    '}';
        }

        public int getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(int beginTime) {
            this.beginTime = beginTime;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getWhetherComment() {
            return whetherComment;
        }

        public void setWhetherComment(int whetherComment) {
            this.whetherComment = whetherComment;
        }
    }
}
