package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/20
 *@Time:14:20
 *@Description:影评
 **/
public class PingBean {
    /**
     * result : [{"commentContent":"真好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2177,"commentTime":1574162336000,"commentUserId":13766,"commentUserName":"nideyifa","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"这是在陆路","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204216.png","commentId":2088,"commentTime":1572869453000,"commentUserId":13708,"commentUserName":"郭转晨","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025152747.jpg","commentId":1867,"commentTime":1572003461000,"commentUserId":13610,"commentUserName":"诺","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.5},{"commentContent":"一般","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025160324.jpg","commentId":1815,"commentTime":1571982627000,"commentUserId":13609,"commentUserName":"wanggangwang","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1761,"commentTime":1571637960000,"commentUserId":13689,"commentUserName":"婉珍","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":1742,"commentTime":1571626749000,"commentUserId":13665,"commentUserName":"123456789","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"很好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115202633.jpg","commentId":1709,"commentTime":1571314348000,"commentUserId":13711,"commentUserName":"西泠桥畔","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.2},{"commentContent":"asdsad","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-24/20191024160418.unknown","commentId":1680,"commentTime":1570967800000,"commentUserId":13542,"commentUserName":"杨海鹏","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"https://www.baidu.com/cache/icon/favicon.ico","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025160441.png","commentId":1668,"commentTime":1570603659000,"commentUserId":13594,"commentUserName":"张嵩鹏","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"055","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-09-23/20190923191522.unknown","commentId":934,"commentTime":1569377804000,"commentUserId":13643,"commentUserName":"������ҵ","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":2}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "PingBean{" +
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
         * commentContent : 真好
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 2177
         * commentTime : 1574162336000
         * commentUserId : 13766
         * commentUserName : nideyifa
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "commentContent='" + commentContent + '\'' +
                    ", commentHeadPic='" + commentHeadPic + '\'' +
                    ", commentId=" + commentId +
                    ", commentTime=" + commentTime +
                    ", commentUserId=" + commentUserId +
                    ", commentUserName='" + commentUserName + '\'' +
                    ", greatNum=" + greatNum +
                    ", isGreat=" + isGreat +
                    ", replyNum=" + replyNum +
                    ", score=" + score +
                    ", replyHeadPic=" + replyHeadPic +
                    '}';
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
