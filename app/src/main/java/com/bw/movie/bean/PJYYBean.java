package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/3
 *@Time:21:42
 *@Description:我的影院评价
 **/
public class PJYYBean {
    /**
     * result : [{"address":"滨河路乙1号雍和航星园74-76号楼","cinemaId":1,"cinemaName":"青春光线电影院","commentTime":1575380364000,"distance":0,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","myCommentContent":"很棒"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "PJYYBean{" +
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
         * address : 滨河路乙1号雍和航星园74-76号楼
         * cinemaId : 1
         * cinemaName : 青春光线电影院
         * commentTime : 1575380364000
         * distance : 0
         * logo : http://172.17.8.100/images/movie/logo/qcgx.jpg
         * myCommentContent : 很棒
         */

        private String address;
        private int cinemaId;
        private String cinemaName;
        private long commentTime;
        private int distance;
        private String logo;
        private String myCommentContent;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "address='" + address + '\'' +
                    ", cinemaId=" + cinemaId +
                    ", cinemaName='" + cinemaName + '\'' +
                    ", commentTime=" + commentTime +
                    ", distance=" + distance +
                    ", logo='" + logo + '\'' +
                    ", myCommentContent='" + myCommentContent + '\'' +
                    '}';
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }
    }
}
