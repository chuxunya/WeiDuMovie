package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/5
 *@Time:20:34
 *@Description:系统信息
 **/
public class XTBean {
    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9403,"pushTime":1575527859000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9402,"pushTime":1575527810000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9390,"pushTime":1575525134000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9389,"pushTime":1575524990000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9388,"pushTime":1575524970000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9386,"pushTime":1575524309000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9385,"pushTime":1575524285000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9384,"pushTime":1575524271000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9383,"pushTime":1575524260000,"status":0,"title":"系统通知","userId":13793},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":9376,"pushTime":1575520256000,"status":0,"title":"系统通知","userId":13793}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "XTBean{" +
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
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 9403
         * pushTime : 1575527859000
         * status : 0
         * title : 系统通知
         * userId : 13793
         */

        private String content;
        private int id;
        private long pushTime;
        private int status;
        private String title;
        private int userId;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "content='" + content + '\'' +
                    ", id=" + id +
                    ", pushTime=" + pushTime +
                    ", status=" + status +
                    ", title='" + title + '\'' +
                    ", userId=" + userId +
                    '}';
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
