package com.maizi.fund.model.domain;

import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 3:41 下午
 */
public class InvtCashGuideDO {
    // 客户姓名
    private String realName;

    // 注册时间
    private String registerTime;

    // 充值笔数
    private String rechargeCnt;

    // 充值金额
    private String biRechargeSum;

    // 提现笔数
    private String withdrawCnt;

    // 提现总额
    private String biWithdrawSum;

    // 当前余额
    private String biSevenBalance;

    // 当前精选余额
    private String biThirteenBalance;

    // 财神原账户
    private String biCsBalance;

    // 转让折扣损失加总
    private String biTransferLoss;

    // 原始本金
    private String biOriginalCapital;


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRechargeCnt() {
        return rechargeCnt;
    }

    public void setRechargeCnt(String rechargeCnt) {
        this.rechargeCnt = rechargeCnt;
    }

    public String getBiRechargeSum() {
        return biRechargeSum;
    }

    public void setBiRechargeSum(String biRechargeSum) {
        this.biRechargeSum = biRechargeSum;
    }

    public String getWithdrawCnt() {
        return withdrawCnt;
    }

    public void setWithdrawCnt(String withdrawCnt) {
        this.withdrawCnt = withdrawCnt;
    }

    public String getBiWithdrawSum() {
        return biWithdrawSum;
    }

    public void setBiWithdrawSum(String biWithdrawSum) {
        this.biWithdrawSum = biWithdrawSum;
    }

    public String getBiSevenBalance() {
        return biSevenBalance;
    }

    public void setBiSevenBalance(String biSevenBalance) {
        this.biSevenBalance = biSevenBalance;
    }

    public String getBiThirteenBalance() {
        return biThirteenBalance;
    }

    public void setBiThirteenBalance(String biThirteenBalance) {
        this.biThirteenBalance = biThirteenBalance;
    }

    public String getBiCsBalance() {
        return biCsBalance;
    }

    public void setBiCsBalance(String biCsBalance) {
        this.biCsBalance = biCsBalance;
    }

    public String getBiTransferLoss() {
        return biTransferLoss;
    }

    public void setBiTransferLoss(String biTransferLoss) {
        this.biTransferLoss = biTransferLoss;
    }

    public String getBiOriginalCapital() {
        return biOriginalCapital;
    }

    public void setBiOriginalCapital(String biOriginalCapital) {
        this.biOriginalCapital = biOriginalCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvtCashGuideDO that = (InvtCashGuideDO) o;
        return Objects.equals(realName, that.realName) &&
                Objects.equals(registerTime, that.registerTime) &&
                Objects.equals(rechargeCnt, that.rechargeCnt) &&
                Objects.equals(biRechargeSum, that.biRechargeSum) &&
                Objects.equals(withdrawCnt, that.withdrawCnt) &&
                Objects.equals(biWithdrawSum, that.biWithdrawSum) &&
                Objects.equals(biSevenBalance, that.biSevenBalance) &&
                Objects.equals(biThirteenBalance, that.biThirteenBalance) &&
                Objects.equals(biCsBalance, that.biCsBalance) &&
                Objects.equals(biTransferLoss, that.biTransferLoss) &&
                Objects.equals(biOriginalCapital, that.biOriginalCapital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realName, registerTime, rechargeCnt, biRechargeSum, withdrawCnt, biWithdrawSum, biSevenBalance, biThirteenBalance, biCsBalance, biTransferLoss, biOriginalCapital);
    }

    @Override
    public String toString() {
        return "InvtCashGuide{" +
                "realName='" + realName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", rechargeCnt='" + rechargeCnt + '\'' +
                ", biRechargeSum='" + biRechargeSum + '\'' +
                ", withdrawCnt='" + withdrawCnt + '\'' +
                ", biWithdrawSum='" + biWithdrawSum + '\'' +
                ", biSevenBalance='" + biSevenBalance + '\'' +
                ", biThirteenBalance='" + biThirteenBalance + '\'' +
                ", biCsBalance='" + biCsBalance + '\'' +
                ", biTransferLoss='" + biTransferLoss + '\'' +
                ", biOriginalCapital='" + biOriginalCapital + '\'' +
                '}';
    }
}
