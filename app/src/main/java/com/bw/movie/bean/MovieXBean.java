package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/30
 *@Time:12:50
 *@Description:订单详情
 **/
public class MovieXBean {
    /**
     * result : {"amount":1,"beginTime":"18:30:00","cinemaName":"北京百老汇影城国瑞购物中心店","createTime":1575081345000,"endTime":"19:55:00","id":5320,"movieName":"少年的你","orderId":"20191130103545849","price":0.01,"screeningHall":"6号厅","seat":"4-5","status":2,"userId":13793}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "MovieXBean{" +
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
         * amount : 1
         * beginTime : 18:30:00
         * cinemaName : 北京百老汇影城国瑞购物中心店
         * createTime : 1575081345000
         * endTime : 19:55:00
         * id : 5320
         * movieName : 少年的你
         * orderId : 20191130103545849
         * price : 0.01
         * screeningHall : 6号厅
         * seat : 4-5
         * status : 2
         * userId : 13793
         */

        private int amount;
        private String beginTime;
        private String cinemaName;
        private long createTime;
        private String endTime;
        private int id;
        private String movieName;
        private String orderId;
        private double price;
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
                    ", orderId='" + orderId + '\'' +
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

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
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
