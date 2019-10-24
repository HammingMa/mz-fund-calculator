package com.maizi.fund.model.domain;

public class AggreementLocation {

    private String userId;
    private String pType;
    private String transId;
    private String aggreementTime ;
    private String aggreementLocation;
    private String pdfLocation;

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

    public void setAggreementLocation(String aggreementTocation) {
        this.aggreementLocation = aggreementTocation;
    }

    public String getPdfLocation() {
        return pdfLocation;
    }

    public void setPdfLocation(String pdfLocation) {
        this.pdfLocation = pdfLocation;
    }

    @Override
    public String toString() {
        return "AggreementLocation{" +
                "userId='" + userId + '\'' +
                ", pType='" + pType + '\'' +
                ", transId='" + transId + '\'' +
                ", aggreementTime='" + aggreementTime + '\'' +
                ", aggreementTocation='" + aggreementLocation + '\'' +
                ", pdfLocation='" + pdfLocation + '\'' +
                '}';
    }
}
