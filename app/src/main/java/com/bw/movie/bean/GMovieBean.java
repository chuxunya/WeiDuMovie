package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/2
 *@Time:21:38
 *@Description:关注的电影
 **/
public class GMovieBean {
    /**
     * result : [{"director":"刘阔","imageUrl":"http://172.17.8.100/images/movie/stills/fyz/fyz1.jpg","movieId":12,"name":"风语咒","score":9.7,"starring":"路知行,阎萌萌,褚珺"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "GMovieBean{" +
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
         * director : 刘阔
         * imageUrl : http://172.17.8.100/images/movie/stills/fyz/fyz1.jpg
         * movieId : 12
         * name : 风语咒
         * score : 9.7
         * starring : 路知行,阎萌萌,褚珺
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
