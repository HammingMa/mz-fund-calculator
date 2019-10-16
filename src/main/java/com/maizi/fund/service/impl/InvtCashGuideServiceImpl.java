package com.maizi.fund.service.impl;

import com.maizi.fund.mapper.InvtCashGuideMapper;
import com.maizi.fund.model.domain.InvtCashGuideDO;
import com.maizi.fund.model.domain.RechargeDetailDO;
import com.maizi.fund.model.domain.WithdrawDetailDO;
import com.maizi.fund.service.InvtCashGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:16 下午
 */
@Service(value = "invtCashGuideService")
public class InvtCashGuideServiceImpl implements InvtCashGuideService {
    @Autowired
    private InvtCashGuideMapper invtCashGuideMapper;


    @Override
    public InvtCashGuideDO selectIvt(String mobileNum, String idNum) {

        InvtCashGuideDO invtCashGuideDO = invtCashGuideMapper.selectIvt(mobileNum, idNum);

        System.out.println("2229999" + invtCashGuideDO);
        return invtCashGuideDO;
    }

    @Override
    public List<RechargeDetailDO> selectRechargeDetail(String mobileNum, String idNum) {
        return invtCashGuideMapper.selectRechargeDetail(mobileNum, idNum);
    }

    @Override
    public List<WithdrawDetailDO> selectWithdrawDetail(String mobileNum, String idNum) {
        return invtCashGuideMapper.selectWithdrawDetail(mobileNum, idNum);
    }
}
