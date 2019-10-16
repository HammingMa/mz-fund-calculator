package com.maizi.fund.model.domain;

import com.maizi.fund.utils.NumberFormatUtils;

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

    // 身份证号
    private String idNum;

    // 手机号
    private String mobileNum;

    // 匹配债权金额
    private String biDebtCapitalSum;

    // 匹配债权金额 * 0.8
    private String biDebtCapitalSumEight;

    public String getBiDebtCapitalSumEight() {
        return biDebtCapitalSumEight;
    }

    public void setBiDebtCapitalSumEight(String biDebtCapitalSumEight) {
        this.biDebtCapitalSumEight = NumberFormatUtils.getInstance().formatNum(biDebtCapitalSumEight);
    }

    public String getBiDebtCapitalSum() {
        return biDebtCapitalSum;
    }

    public void setBiDebtCapitalSum(String biDebtCapitalSum) {
        this.biDebtCapitalSum = NumberFormatUtils.getInstance().formatNum(biDebtCapitalSum);
    }


    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum.replaceAll("(\\d{6})\\d{8}(\\d{4})", "$1********$2");;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = NumberFormatUtils.getInstance().replaceNameX(realName);
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

        // 格式化 充值金额
        String rs = NumberFormatUtils.getInstance().formatNum(biRechargeSum);
//        this.biRechargeSum = biRechargeSum;
        this.biRechargeSum = rs;
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
        // 格式化 提现总额
        this.biWithdrawSum = NumberFormatUtils.getInstance().formatNum(biWithdrawSum);
    }

    public String getBiSevenBalance() {
        return biSevenBalance;
    }

    public void setBiSevenBalance(String biSevenBalance) {
        // 当前余额
        this.biSevenBalance = NumberFormatUtils.getInstance().formatNum(biSevenBalance);
    }

    public String getBiThirteenBalance() {
        return biThirteenBalance;
    }

    public void setBiThirteenBalance(String biThirteenBalance) {
        // 当前精选余额
        this.biThirteenBalance = NumberFormatUtils.getInstance().formatNum(biThirteenBalance);
    }

    public String getBiCsBalance() {
        // 财神原账户
        if (biCsBalance == null) {
            return "0";
        }
        return biCsBalance;
    }

    public void setBiCsBalance(String biCsBalance) {
        this.biCsBalance = NumberFormatUtils.getInstance().formatNum(biCsBalance);
    }

    public String getBiTransferLoss() {
        // 财神原账户
        if (biTransferLoss == null) {
            return "0";
        }
        return NumberFormatUtils.getInstance().formatNum(biTransferLoss);
    }

    public void setBiTransferLoss(String biTransferLoss) {
        this.biTransferLoss = biTransferLoss;
    }

    public String getBiOriginalCapital() {
        return biOriginalCapital;
    }

    public void setBiOriginalCapital(String biOriginalCapital) {
        this.biOriginalCapital = NumberFormatUtils.getInstance().formatNum(biOriginalCapital);
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
                Objects.equals(biOriginalCapital, that.biOriginalCapital) &&
                Objects.equals(idNum, that.idNum) &&
                Objects.equals(mobileNum, that.mobileNum) &&
                Objects.equals(biDebtCapitalSum, that.biDebtCapitalSum) &&
                Objects.equals(biDebtCapitalSumEight, that.biDebtCapitalSumEight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realName, registerTime, rechargeCnt, biRechargeSum, withdrawCnt, biWithdrawSum, biSevenBalance, biThirteenBalance, biCsBalance, biTransferLoss, biOriginalCapital, idNum, mobileNum, biDebtCapitalSum, biDebtCapitalSumEight);
    }


    @Override
    public String toString() {
        return "InvtCashGuideDO{" +
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
                ", idNum='" + idNum + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", biDebtCapitalSum='" + biDebtCapitalSum + '\'' +
                ", biDebtCapitalSumEight='" + biDebtCapitalSumEight + '\'' +
                '}';
    }
}
