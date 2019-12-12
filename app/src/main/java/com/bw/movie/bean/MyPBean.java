package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/12/4
 *@Time:13:29
 *@Description:我的电影票
 **/
public class MyPBean {
    /**
     * result : [{"amount":0,"beginTime":"20:30:00","cinemaName":"青春光线电影院","createTime":1575279088000,"endTime":"22:28:00","id":5625,"movieName":"西虹市首富","price":0,"screeningHall":"2号激光厅","seat":"4-8","status":0,"userId":0},{"amount":0,"beginTime":"18:30:00","cinemaName":"北京百老汇影城国瑞购物中心店","createTime":1575081345000,"endTime":"19:55:00","id":5320,"movieName":"少年的你","price":0,"screeningHall":"6号厅","seat":"4-5","status":0,"userId":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "MyPBean{" +
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
         * amount : 0
         * beginTime : 20:30:00
         * cinemaName : 青春光线电影院
         * createTime : 1575279088000
         * endTime : 22:28:00
         * id : 5625
         * movieName : 西虹市首富
         * price : 0
         * screeningHall : 2号激光厅
         * seat : 4-8
         * status : 0
         * userId : 0
         */

        private int amount;
        private String beginTime;
        private String cinemaName;
        private long createTime;
        private String endTime;
        private int id;
        private String movieName;
        private int price;
        private String screeningHall;
        private String seat;
        private int status;
        private int userId;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "amount=" + amount +
                    ", beginTime='" + beginTime + '\'' +
                    ", cinemaName='" + cinemaName + '\'' +
                    ", createTime=" + createTime +
                    ", endTime='" + endTime + '\'' +
                    ", id=" + id +
                    ", movieName='" + movieName + '\'' +
                    ", price=" + price +
                    ", screeningHall='" + screeningHall + '\'' +
                    ", seat='" + seat + '\'' +
                    ", status=" + status +
                    ", userId=" + userId +
                    '}';
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getCinemaName() {
            return cinemaName;
        }

        public void setCinemaName(String cinemaName) {
            this.cinemaName = cinemaName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }

        public String getSeat() {
            return seat;
        }

        public void setSeat(String seat) {
            this.seat = seat;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
