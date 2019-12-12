package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/12
 *@Time:20:03
 *@Description:轮播图bean
 **/
public class BannerBean {
    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1_h.jpg","jumpUrl":"wd://movie?movieId=16","rank":1},{"imageUrl":"http://172.17.8.100/images/movie/stills/mtyj/mtyj1_h.jpg","jumpUrl":"wd://movie?movieId=2","rank":2},{"imageUrl":"http://172.17.8.100/images/movie/stills/ws/ws1_h.jpg","jumpUrl":"wd://movie?movieId=20","rank":3},{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1_h.jpg","jumpUrl":"wd://movie?movieId=6","rank":4},{"imageUrl":"http://172.17.8.100/images/movie/stills/dwsj/dwsj1_h.jpg","jumpUrl":"wd://movie?movieId=10","rank":5}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "BannerBean{" +
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
         * imageUrl : http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1_h.jpg
         * jumpUrl : wd://movie?movieId=16
         * rank : 1
         */

        private String imageUrl;
        private String jumpUrl;
        private int rank;
        private int movieId;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "imageUrl='" + imageUrl + '\'' +
                    ", jumpUrl='" + jumpUrl + '\'' +
                    ", rank=" + rank +
                    ", movieId=" + movieId +
                    '}';
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }
    }
}
