package com.maizi.fund.controller;

import com.maizi.fund.model.domain.InvtCashGuideDO;
import com.maizi.fund.model.domain.RechargeDetailDO;
import com.maizi.fund.model.domain.WithdrawDetailDO;
import com.maizi.fund.service.InvtCashGuideService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:18 下午
 */
@Controller
@RequestMapping("/mz1")
public class AggreementLocationController {


    //@Autowired
    //private HttpServletResponse response;


    @Autowired
    private InvtCashGuideService invtCashGuideService;



    @RequestMapping(method = RequestMethod.GET)
    public String getIndex_agg() {

//        InvtCashGuideDO invtCashGuideDO = invtCashGuideService.selectIvt(mobileNum);
//        System.out.println(invtCashGuideDO);
        return "index_agg";
    }

    @PostMapping("/fund/serchAggreementLocation")
    public String getAggreementLocation(ModelMap map,
                                        @RequestParam(name = "user_id", required = true) String userId,
                                        @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                        @RequestParam(name = "id_num", required = true) String idNum){

        map.addAttribute("aggreementLocations",invtCashGuideService.selectAggreementLocations(userId,mobileNum,idNum));

        return "aggreement_location";

    }

}
