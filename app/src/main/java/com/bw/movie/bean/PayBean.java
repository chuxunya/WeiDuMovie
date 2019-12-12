package com.bw.movie.bean;

/*
 *@auther:王可欣
 *@Date: 2019/11/29
 *@Time:20:01
 *@Description:支付
 **/
public class PayBean {
    /**
     * appId : wxb3852e6a6b7d9516
     * message : 支付成功
     * nonceStr : S7urLOZySlWpveBW
     * packageValue : Sign=WXPay
     * partnerId : 1510865081
     * prepayId : wx292000359598022d690fc7251669016200
     * sign : CAD99FC9379FA2FAD64FD81B77D97F7C
     * status : 0000
     * timeStamp : 1575028783
     */

    private String appId;
    private String message;
    private String nonceStr;
    private String packageValue;
    private String partnerId;
    private String prepayId;
    private String sign;
    private String status;
    private String timeStamp;

    @Override
    public String toString() {
        return "PayBean{" +
                "appId='" + appId + '\'' +
                ", message='" + message + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", packageValue='" + packageValue + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", sign='" + sign + '\'' +
                ", status='" + status + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
