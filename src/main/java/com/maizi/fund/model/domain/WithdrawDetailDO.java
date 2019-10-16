package com.maizi.fund.model.domain;

import com.maizi.fund.utils.NumberFormatUtils;

import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 7:45 下午
 */
public class WithdrawDetailDO {

    private String withdrawCnt;
    private String withdrawType;
    private String withdrawTime;
    private String withdrawAmount;

    public String getWithdrawCnt() {
        return withdrawCnt;
    }

    public void setWithdrawCnt(String withdrawCnt) {
        this.withdrawCnt = withdrawCnt;
    }

    public String getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType;
    }

    public String getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(String withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    public String getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(String withdrawAmount) {
        this.withdrawAmount = NumberFormatUtils.getInstance().formatNum(withdrawAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawDetailDO that = (WithdrawDetailDO) o;
        return Objects.equals(withdrawCnt, that.withdrawCnt) &&
                Objects.equals(withdrawType, that.withdrawType) &&
                Objects.equals(withdrawTime, that.withdrawTime) &&
                Objects.equals(withdrawAmount, that.withdrawAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(withdrawCnt, withdrawType, withdrawTime, withdrawAmount);
    }


    @Override
    public String toString() {
        return "WithdrawDetailDO{" +
                "withdrawCnt='" + withdrawCnt + '\'' +
                ", withdrawType='" + withdrawType + '\'' +
                ", withdrawTime='" + withdrawTime + '\'' +
                ", withdrawAmount='" + withdrawAmount + '\'' +
                '}';
    }
}
