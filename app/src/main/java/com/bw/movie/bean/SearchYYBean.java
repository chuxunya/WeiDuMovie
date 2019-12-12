package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/8
 *@Time:18:52
 *@Description:影院搜索
 **/
public class SearchYYBean {
    /**
     * result : [{"address":"建国路93号万达广场三层","commentTotal":0,"distance":0,"followCinema":0,"id":6,"logo":"http://mobile.bwstudent.com/images/movie/logo/wd.jpg","name":"北京CBD万达广场店"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "SearchYYBean{" +
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
         * address : 建国路93号万达广场三层
         * commentTotal : 0
         * distance : 0
         * followCinema : 0
         * id : 6
         * logo : http://mobile.bwstudent.com/images/movie/logo/wd.jpg
         * name : 北京CBD万达广场店
         */

        private String address;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String logo;
        private String name;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "address='" + address + '\'' +
                    ", commentTotal=" + commentTotal +
                    ", distance=" + distance +
                    ", followCinema=" + followCinema +
                    ", id=" + id +
                    ", logo='" + logo + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
