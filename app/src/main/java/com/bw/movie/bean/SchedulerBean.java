package com.bw.movie.bean;

import java.util.List;

/*
 *@auther:王可欣
 *@Date: 2019/11/21
 *@Time:10:48
 *@Description:根据movieId 影院id 查看电影排期
 **/
public class SchedulerBean {
    /**
     * result : [{"beginTime":"20:40:00","endTime":"22:16:00","fare":0.01,"hallId":106,"id":345,"screeningHall":"9号厅"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "SchedulerBean{" +
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
         * beginTime : 20:40:00
         * endTime : 22:16:00
         * fare : 0.01
         * hallId : 106
         * id : 345
         * screeningHall : 9号厅
         */

        private String beginTime;
        private String endTime;
        private double fare;
        private int hallId;
        private int id;
        private String screeningHall;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "beginTime='" + beginTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", fare=" + fare +
                    ", hallId=" + hallId +
                    ", id=" + id +
                    ", screeningHall='" + screeningHall + '\'' +
                    '}';
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public int getHallId() {
            return hallId;
        }

        public void setHallId(int hallId) {
            this.hallId = hallId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
