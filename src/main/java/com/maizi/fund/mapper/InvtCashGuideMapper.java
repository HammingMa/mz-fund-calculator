package com.maizi.fund.mapper;

import com.maizi.fund.model.domain.InvtCashGuideDO;
import com.maizi.fund.model.domain.RechargeDetailDO;
import com.maizi.fund.model.domain.WithdrawDetailDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:07 下午
 */
@Mapper
public interface InvtCashGuideMapper {

    InvtCashGuideDO selectIvt(@Param("mobile_num") String mobileNum,
                              @Param("id_num") String idNum);

    List<RechargeDetailDO> selectRechargeDetail(@Param("mobile_num") String mobileNum,
                                          @Param("id_num") String idNum);


    List<WithdrawDetailDO> selectWithdrawDetail(@Param("mobile_num") String mobileNum,
                                          @Param("id_num") String idNum);


    @Select("SELECT \n" +
        "real_name AS realName,\n" +
        "register_time AS registerTime,\n" +
        "recharge_cnt AS rechargeCnt,\n" +
        "bi_recharge_sum AS biRechargeSum,\n" +
        "withdraw_cnt AS withdrawCnt,\n" +
        "bi_withdraw_sum AS biWithdrawSum,\n" +
        "bi_seven_balance AS biSevenBalance,\n" +
        "bi_thirteen_balance AS biThirteenBalance,\n" +
        "bi_cs_balance AS biCsBalance,\n" +
        "bi_transfer_loss AS biTransferLoss,\n" +
        "bi_original_capital AS biOriginalCapital\n" +
        "FROM dmt.invt_cash_guide\n" +
        "WHERE stat_date='2019-10-13' \n" +
        "AND bi_debt_capital_sum>0\n" +
        "AND mobile_num=#{mobile_num};")
    InvtCashGuideDO selectIvt2(@Param("mobile_num") String mobileNum);


}
