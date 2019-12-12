package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/15
 *@Time:21:26
 *@Description:电影详情
 **/
public class XiangBean {

    /**
     * result : {"commentNum":13,"duration":"94分钟","imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1.jpg","movieActor":[{"name":"艾米莉·布朗特","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/aimili.jpg","role":"乔伊"},{"name":"约翰·卡拉辛斯基","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/yuehan.jpg","role":"欧文"},{"name":"西尔维斯特·史泰龙","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/shitailong.jpg","role":"子弹侠"}],"movieDirector":[{"name":"托尼·班克罗夫特","photo":"http://172.17.8.100/images/movie/director/sqmxtzdwbg/1.jpg"}],"movieId":6,"movieType":"喜剧 / 家庭 / 动画","name":"神奇马戏团之动物饼干","placeOrigin":"美国","posterList":["http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg2.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg3.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg4.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg5.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg6.jpg"],"releaseTime":1536336000000,"score":9.1,"shortFilmList":[{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg3.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg2.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg4.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj3.ts"}],"summary":"欧文的叔叔在经营着一家以动物表演闻名的马戏团，但一场大火却让叔叔意外去世，马戏团的表演场也全部化为灰烬。此时，继承马戏团的重担落在了欧文身上，但他却显得犹豫不决，而在叔叔的葬礼上，大伯霍勒肖放话要继承马戏团和宝藏，小丑红鼻头也将一盒贴着\u201c绝对不能吃\u201d的动物饼干交给了欧文，令局势更加混乱\u2026\u2026","whetherFollow":2}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "XiangBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
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

    public static class ResultBean {
        /**
         * commentNum : 13
         * duration : 94分钟
         * imageUrl : http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1.jpg
         * movieActor : [{"name":"艾米莉·布朗特","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/aimili.jpg","role":"乔伊"},{"name":"约翰·卡拉辛斯基","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/yuehan.jpg","role":"欧文"},{"name":"西尔维斯特·史泰龙","photo":"http://172.17.8.100/images/movie/actor/sqmxtzdwbg/shitailong.jpg","role":"子弹侠"}]
         * movieDirector : [{"name":"托尼·班克罗夫特","photo":"http://172.17.8.100/images/movie/director/sqmxtzdwbg/1.jpg"}]
         * movieId : 6
         * movieType : 喜剧 / 家庭 / 动画
         * name : 神奇马戏团之动物饼干
         * placeOrigin : 美国
         * posterList : ["http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg2.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg3.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg4.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg5.jpg","http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg6.jpg"]
         * releaseTime : 1536336000000
         * score : 9.1
         * shortFilmList : [{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg3.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj1.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg2.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj2.ts"},{"imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg4.jpg","videoUrl":"http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj3.ts"}]
         * summary : 欧文的叔叔在经营着一家以动物表演闻名的马戏团，但一场大火却让叔叔意外去世，马戏团的表演场也全部化为灰烬。此时，继承马戏团的重担落在了欧文身上，但他却显得犹豫不决，而在叔叔的葬礼上，大伯霍勒肖放话要继承马戏团和宝藏，小丑红鼻头也将一盒贴着“绝对不能吃”的动物饼干交给了欧文，令局势更加混乱……
         * whetherFollow : 2
         */

        private int commentNum;
        private String duration;
        private String imageUrl;
        private int movieId;
        private String movieType;
        private String name;
        private String placeOrigin;
        private long releaseTime;
        private double score;
        private String summary;
        private int whetherFollow;
        private List<MovieActorBean> movieActor;
        private List<MovieDirectorBean> movieDirector;
        private List<String> posterList;
        private List<ShortFilmListBean> shortFilmList;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "commentNum=" + commentNum +
                    ", duration='" + duration + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieId=" + movieId +
                    ", movieType='" + movieType + '\'' +
                    ", name='" + name + '\'' +
                    ", placeOrigin='" + placeOrigin + '\'' +
                    ", releaseTime=" + releaseTime +
                    ", score=" + score +
                    ", summary='" + summary + '\'' +
                    ", whetherFollow=" + whetherFollow +
                    ", movieActor=" + movieActor +
                    ", movieDirector=" + movieDirector +
                    ", posterList=" + posterList +
                    ", shortFilmList=" + shortFilmList +
                    '}';
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

        public String getMovieType() {
            return movieType;
        }

        public void setMovieType(String movieType) {
            this.movieType = movieType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlaceOrigin() {
            return placeOrigin;
        }

        public void setPlaceOrigin(String placeOrigin) {
            this.placeOrigin = placeOrigin;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public List<MovieActorBean> getMovieActor() {
            return movieActor;
        }

        public void setMovieActor(List<MovieActorBean> movieActor) {
            this.movieActor = movieActor;
        }

        public List<MovieDirectorBean> getMovieDirector() {
            return movieDirector;
        }

        public void setMovieDirector(List<MovieDirectorBean> movieDirector) {
            this.movieDirector = movieDirector;
        }

        public List<String> getPosterList() {
            return posterList;
        }

        public void setPosterList(List<String> posterList) {
            this.posterList = posterList;
        }

        public List<ShortFilmListBean> getShortFilmList() {
            return shortFilmList;
        }

        public void setShortFilmList(List<ShortFilmListBean> shortFilmList) {
            this.shortFilmList = shortFilmList;
        }

        public static class MovieActorBean {
            /**
             * name : 艾米莉·布朗特
             * photo : http://172.17.8.100/images/movie/actor/sqmxtzdwbg/aimili.jpg
             * role : 乔伊
             */

            private String name;
            private String photo;
            private String role;

            @Override
            public String toString() {
                return "MovieActorBean{" +
                        "name='" + name + '\'' +
                        ", photo='" + photo + '\'' +
                        ", role='" + role + '\'' +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class MovieDirectorBean {
            /**
             * name : 托尼·班克罗夫特
             * photo : http://172.17.8.100/images/movie/director/sqmxtzdwbg/1.jpg
             */

            private String name;
            private String photo;

            @Override
            public String toString() {
                return "MovieDirectorBean{" +
                        "name='" + name + '\'' +
                        ", photo='" + photo + '\'' +
                        '}';
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ShortFilmListBean {
            /**
             * imageUrl : http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg3.jpg
             * videoUrl : http://172.17.8.100/video/movie/sqmxtzdwsj/sqmxtzdwsj1.ts
             */

            private String imageUrl;
            private String videoUrl;

            @Override
            public String toString() {
                return "ShortFilmListBean{" +
                        "imageUrl='" + imageUrl + '\'' +
                        ", videoUrl='" + videoUrl + '\'' +
                        '}';
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }
        }
    }
}
