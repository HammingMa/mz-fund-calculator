package com.maizi.fund.controller;

import com.maizi.fund.model.domain.*;
import com.maizi.fund.service.InvtCashGuideService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:18 下午
 */
@Controller
@RequestMapping("/mz")
public class InvtCashGuideController {

    @Autowired
    private InvtCashGuideService invtCashGuideService;



    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {

//        InvtCashGuideDO invtCashGuideDO = invtCashGuideService.selectIvt(mobileNum);
//
//        System.out.println(invtCashGuideDO);

        return "index";
    }


    @PostMapping("/fund/search")
    public String getEmployeeById(ModelMap map,
                                  @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                  @RequestParam(name = "id_num", required = true) String idNum) {

        System.out.println("-444666----" + mobileNum);
        System.out.println("-444888----" + idNum);

        System.out.println("".equals(idNum));

        System.out.println(idNum == null);

        InvtCashGuideDO invtCashGuideDO = invtCashGuideService.selectIvt(mobileNum, idNum);

        List<RechargeDetailDO> rechargeDetailDoList = invtCashGuideService.selectRechargeDetail(mobileNum, idNum);
        List<WithdrawDetailDO> withdrawDetailDoList = invtCashGuideService.selectWithdrawDetail(mobileNum, idNum);

        map.addAttribute("invtCashGuideDO", invtCashGuideDO);
        map.addAttribute("rechargeDetailDoList", rechargeDetailDoList);
        map.addAttribute("withdrawDetailDoList", withdrawDetailDoList);

        System.out.println(invtCashGuideDO);

        return "result_div";
    }
}
