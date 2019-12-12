package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/30
 *@Time:18:40
 *@Description:关键字搜索影片
 **/
public class SearchBean {
    /**
     * result : [{"director":"陈凯歌","imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieId":23,"name":"我和我的祖国","score":9.7,"starring":"黄渤,张译,杜江,葛优,刘昊然,吴京"},{"director":"文牧野","imageUrl":"http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg","movieId":1,"name":"我不是药神","score":8.9,"starring":"徐峥,周一围,王传君,谭卓,章宇,杨新鸣,王砚辉"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "SearchBean{" +
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
         * director : 陈凯歌
         * imageUrl : http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg
         * movieId : 23
         * name : 我和我的祖国
         * score : 9.7
         * starring : 黄渤,张译,杜江,葛优,刘昊然,吴京
         */

        private String director;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "director='" + director + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieId=" + movieId +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    ", starring='" + starring + '\'' +
                    '}';
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
