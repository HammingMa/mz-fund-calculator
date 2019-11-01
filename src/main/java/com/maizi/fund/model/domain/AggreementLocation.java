package com.maizi.fund.model.domain;

import com.maizi.fund.utils.NumberFormatUtils;

public class AggreementLocation {

    private String userId;
    private String pType;
    private String transId;
    private String aggreementTime ;
    private String aggreementLocation;
    private String pdfLocation;
    private String mobileNum;
    private String originalPrice;
    private String price;
    private String lockPrice;
    private String transferPrice;
    private String repayPrice;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getAggreementTime() {
        return aggreementTime;
    }

    public void setAggreementTime(String aggreementTime) {
        this.aggreementTime = aggreementTime;
    }

    public String getAggreementLocation() {
        return aggreementLocation;
    }

    public void setAggreementLocation(String aggreementLocation) {
        this.aggreementLocation = aggreementLocation;
    }

    public String getPdfLocation() {
        return pdfLocation;
    }

    public void setPdfLocation(String pdfLocation) {
        this.pdfLocation = pdfLocation;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = NumberFormatUtils.getInstance().formatNum(originalPrice);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = NumberFormatUtils.getInstance().formatNum(price);
    }

    public String getLockPrice() {
        return lockPrice;
    }

    public void setLockPrice(String lockPrice) {
        this.lockPrice = NumberFormatUtils.getInstance().formatNum(lockPrice) ;
    }

    public String getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(String transferPrice) {
        this.transferPrice = NumberFormatUtils.getInstance().formatNum(transferPrice) ;
    }

    public String getRepayPrice() {
        return repayPrice;
    }

    public void setRepayPrice(String repayPrice) {
        this.repayPrice = NumberFormatUtils.getInstance().formatNum(repayPrice);
    }

    @Override
    public String toString() {
        return "AggreementLocation{" +
                "userId='" + userId + '\'' +
                ", pType='" + pType + '\'' +
                ", transId='" + transId + '\'' +
                ", aggreementTime='" + aggreementTime + '\'' +
                ", aggreementLocation='" + aggreementLocation + '\'' +
                ", pdfLocation='" + pdfLocation + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", price='" + price + '\'' +
                ", lockPrice='" + lockPrice + '\'' +
                ", transferPrice='" + transferPrice + '\'' +
                ", repayPrice='" + repayPrice + '\'' +
                '}';
    }
}
