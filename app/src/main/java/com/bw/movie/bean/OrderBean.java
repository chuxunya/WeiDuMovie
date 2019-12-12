package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/29
 *@Time:13:18
 *@Description:
 **/
public class OrderBean {
    /**
     * orderId : 20191129131438794
     * message : 下单成功
     * status : 0000
     */

    private String orderId;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
}
