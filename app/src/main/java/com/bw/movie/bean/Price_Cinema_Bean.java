package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/20
 *@Time:21:14
 *@Description:根据电影价格查询播放影院信息
 **/
public class Price_Cinema_Bean {
    /**
     * result : [{"address":"建国门外大街1号国贸商城区域三地下一层3B120","cinemaId":7,"logo":"http://172.17.8.100/images/movie/logo/blg.jpg","name":"北京百丽宫影城","price":0.11},{"address":"崇文门外大街18号国瑞城首层、地下二层","cinemaId":9,"logo":"http://172.17.8.100/images/movie/logo/blh.jpg","name":"北京百老汇影城国瑞购物中心店","price":0.13},{"address":"天桥南大街3号楼一层、二层（天桥艺术大厦南侧）","cinemaId":3,"logo":"http://172.17.8.100/images/movie/logo/sd.jpg","name":"首都电影院","price":0.18},{"address":"滨河路乙1号雍和航星园74-76号楼","cinemaId":1,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","name":"青春光线电影院","price":0.21},{"address":"中关村大街28号","cinemaId":16,"logo":"http://172.17.8.100/images/movie/logo/hdjy.jpg","name":"海淀剧院","price":0.22},{"address":"清河中街68号五彩城购物中心东区7层","cinemaId":22,"logo":"http://172.17.8.100/images/movie/logo/CGVyc.jpg","name":"CGV影城","price":0.22},{"address":"十八里店西直河商业中心东融国际影城","cinemaId":21,"logo":"http://172.17.8.100/images/movie/logo/drgjyc.jpg","name":"东融国际影城西直河店","price":0.25}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "Price_Cinema_Bean{" +
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
         * address : 建国门外大街1号国贸商城区域三地下一层3B120
         * cinemaId : 7
         * logo : http://172.17.8.100/images/movie/logo/blg.jpg
         * name : 北京百丽宫影城
         * price : 0.11
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private double price;

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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
