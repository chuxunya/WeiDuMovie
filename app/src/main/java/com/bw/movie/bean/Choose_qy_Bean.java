package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/20
 *@Time:19:13
 *@Description:区域id
 **/
public class Choose_qy_Bean {
    /**
     * result : [{"address":"天桥南大街3号楼一层、二层（天桥艺术大厦南侧）","cinemaId":3,"logo":"http://172.17.8.100/images/movie/logo/sd.jpg","name":"首都电影院","price":0},{"address":"远大路1号B座5层魔影国际影城","cinemaId":4,"logo":"http://172.17.8.100/images/movie/logo/mygj.jpg","name":"魔影国际影城","price":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "Choose_qy_Bean{" +
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
         * address : 天桥南大街3号楼一层、二层（天桥艺术大厦南侧）
         * cinemaId : 3
         * logo : http://172.17.8.100/images/movie/logo/sd.jpg
         * name : 首都电影院
         * price : 0
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private int price;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "address='" + address + '\'' +
                    ", cinemaId=" + cinemaId +
                    ", logo='" + logo + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
