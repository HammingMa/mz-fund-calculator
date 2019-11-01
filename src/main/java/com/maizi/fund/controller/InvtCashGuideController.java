package com.maizi.fund.controller;

import com.maizi.fund.model.domain.*;
import com.maizi.fund.service.InvtCashGuideService;
import org.apache.ibatis.jdbc.Null;
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
@RequestMapping("/mz")
public class InvtCashGuideController {


    @Autowired
    private HttpServletResponse response;


    @Autowired
    private InvtCashGuideService invtCashGuideService;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex() {

//        InvtCashGuideDO invtCashGuideDO = invtCashGuideService.selectIvt(mobileNum);
//        System.out.println(invtCashGuideDO);
        return "index";
    }


    @PostMapping("/fund/search")
    public String getEmployeeById(ModelMap map,
                                  @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                  @RequestParam(name = "id_num", required = true) String idNum,
                                  @RequestParam(name = "select_time", required = true) String selectTime) {

        InvtCashGuideDO invtCashGuideDO = invtCashGuideService.selectIvt(mobileNum, idNum,selectTime);

        System.out.println("44444" + invtCashGuideDO);

        if (invtCashGuideDO == null) {
            return "no_result";
        }

        List<RechargeDetailDO> rechargeDetailDoList = invtCashGuideService.selectRechargeDetail(mobileNum, idNum,selectTime);
        List<WithdrawDetailDO> withdrawDetailDoList = invtCashGuideService.selectWithdrawDetail(mobileNum, idNum,selectTime);

        map.addAttribute("invtCashGuideDO", invtCashGuideDO);
        map.addAttribute("rechargeDetailDoList", rechargeDetailDoList);
        map.addAttribute("withdrawDetailDoList", withdrawDetailDoList);

        System.out.println(invtCashGuideDO);
        return "result_div";
    }





    @GetMapping("/fund/download")
    @ResponseBody
    public String getDownloadExcel(ModelMap map,
                                   @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                   @RequestParam(name = "id_num", required = true) String idNum,
                                   @RequestParam(name = "select_time", required = true) String selectTime) {

        HSSFWorkbook allInfoExcel = invtCashGuideService.createAllInfoExcel(mobileNum, idNum,selectTime);

        String fileName = mobileNum.isEmpty()?idNum:mobileNum;


        ServletOutputStream out = null;
        try {

            out = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName+".xls", "UTF-8"));
            response.setContentType("application/msexcel;charset=UTF-8");

            allInfoExcel.write(out);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {

                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "download";
    }
}
