package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/3
 *@Time:21:38
 *@Description:查询我的评价
 **/
public class PJBean {
    /**
     * result : [{"commentTime":1575204410000,"director":"李海龙","imageUrl":"http://172.17.8.100/images/movie/stills/jmyx/jmyx1.jpg","movieId":14,"movieName":"解码游戏","movieScore":0,"myCommentContent":"hhh","myCommentScore":5.5,"starring":"韩庚,凤小岳,李媛,山下智久"},{"commentTime":1575203612000,"director":"陈凯歌","imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieId":23,"movieName":"我和我的祖国","movieScore":0,"myCommentContent":"hhh","myCommentScore":5.5,"starring":"黄渤,张译,杜江,葛优,刘昊然,吴京"},{"commentTime":1575203255000,"director":"徐克","imageUrl":"http://172.17.8.100/images/movie/stills/drjzsdtw/drjzsdtw1.jpg","movieId":4,"movieName":"狄仁杰之四大天王","movieScore":0,"myCommentContent":"","myCommentScore":5.5,"starring":"赵又廷,冯绍峰,林更新,刘嘉玲,阮经天,马思纯"},{"commentTime":1575203186000,"director":"曾国祥","imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","movieScore":0,"myCommentContent":"","myCommentScore":5.5,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"commentTime":1575199816000,"director":"韦正","imageUrl":"http://172.17.8.100/images/movie/stills/aqgy/aqgy1.jpg","movieId":15,"movieName":"爱情公寓","movieScore":0,"myCommentContent":"棒棒哒","myCommentScore":5,"starring":"陈赫,娄艺潇,邓家佳,孙艺洲"},{"commentTime":1575098155000,"director":"克里斯托弗·麦奎里","imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"棒棒哒","myCommentScore":5,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"commentTime":1575098146000,"director":"吕乐","imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieId":21,"movieName":"找到你","movieScore":0,"myCommentContent":"棒棒哒","myCommentScore":5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"},{"commentTime":1575086678000,"director":"\r\n李仁港","imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieId":25,"movieName":"攀登者","movieScore":0,"myCommentContent":"棒棒哒","myCommentScore":5,"starring":"吴京,章子怡,井柏然,胡歌"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "PJBean{" +
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
         * commentTime : 1575204410000
         * director : 李海龙
         * imageUrl : http://172.17.8.100/images/movie/stills/jmyx/jmyx1.jpg
         * movieId : 14
         * movieName : 解码游戏
         * movieScore : 0
         * myCommentContent : hhh
         * myCommentScore : 5.5
         * starring : 韩庚,凤小岳,李媛,山下智久
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private double myCommentScore;
        private String starring;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "commentTime=" + commentTime +
                    ", director='" + director + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieId=" + movieId +
                    ", movieName='" + movieName + '\'' +
                    ", movieScore=" + movieScore +
                    ", myCommentContent='" + myCommentContent + '\'' +
                    ", myCommentScore=" + myCommentScore +
                    ", starring='" + starring + '\'' +
                    '}';
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public double getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(double myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
