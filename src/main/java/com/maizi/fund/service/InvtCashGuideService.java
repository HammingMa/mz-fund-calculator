package com.maizi.fund.service;

import com.maizi.fund.model.domain.AggreementLocation;
import com.maizi.fund.model.domain.InvtCashGuideDO;
import com.maizi.fund.model.domain.RechargeDetailDO;
import com.maizi.fund.model.domain.WithdrawDetailDO;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:15 下午
 */
public interface InvtCashGuideService {
    InvtCashGuideDO selectIvt(String mobileNum, String idNum,String selectTime);



    List<RechargeDetailDO> selectRechargeDetail(String mobileNum,
                                                String idNum,String selectTime);


    List<WithdrawDetailDO> selectWithdrawDetail(String mobileNum,
                                                String idNum,String selectTime);

    HSSFWorkbook createAllInfoExcel(String mobileNum, String idNum);

    List<AggreementLocation> selectAggreementLocations(String userId,String mobileNum, String idNum);
}
