package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/29
 *@Time:15:38
 *@Description:购票记录
 **/
public class ReCodeBean {
    /**
     * result : [{"amount":3,"createTime":1575004478000,"id":4124,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191129131438794","price":0.01},{"amount":2,"createTime":1575005708000,"id":4132,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191129133508501","price":0.01},{"amount":2,"createTime":1575006892000,"id":4144,"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieName":"碟中谍6：全面瓦解","orderId":"20191129135452234","price":0.2},{"amount":2,"createTime":1575006910000,"id":4145,"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieName":"碟中谍6：全面瓦解","orderId":"20191129135510126","price":0.2},{"amount":2,"createTime":1575006918000,"id":4146,"imageUrl":"http://172.17.8.100/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieName":"碟中谍6：全面瓦解","orderId":"20191129135518876","price":0.2},{"amount":2,"createTime":1575007187000,"id":4149,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191129135947193","price":0.01},{"amount":2,"createTime":1575007314000,"id":4151,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191129140154603","price":0.01}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "ReCodeBean{" +
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
         * amount : 3
         * createTime : 1575004478000
         * id : 4124
         * imageUrl : http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg
         * movieName : 攀登者
         * orderId : 20191129131438794
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "amount=" + amount +
                    ", createTime=" + createTime +
                    ", id=" + id +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", movieName='" + movieName + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", price=" + price +
                    '}';
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
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
    }
}
