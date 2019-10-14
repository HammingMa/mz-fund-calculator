package com.maizi.fund.model.domain;

import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 7:44 下午
 */
public class RechargeDetailDO {

    private String userName;
    private String rechargeCnt;
    private String rechargeTime;
    private String rechargeAmount;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRechargeCnt() {
        return rechargeCnt;
    }

    public void setRechargeCnt(String rechargeCnt) {
        this.rechargeCnt = rechargeCnt;
    }

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RechargeDetailDO that = (RechargeDetailDO) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(rechargeCnt, that.rechargeCnt) &&
                Objects.equals(rechargeTime, that.rechargeTime) &&
                Objects.equals(rechargeAmount, that.rechargeAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, rechargeCnt, rechargeTime, rechargeAmount);
    }


    @Override
    public String toString() {
        return "RechargeDetailDO{" +
                "userName='" + userName + '\'' +
                ", rechargeCnt='" + rechargeCnt + '\'' +
                ", rechargeTime='" + rechargeTime + '\'' +
                ", rechargeAmount='" + rechargeAmount + '\'' +
                '}';
    }
}
