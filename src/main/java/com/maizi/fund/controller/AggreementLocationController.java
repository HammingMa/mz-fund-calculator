package com.maizi.fund.controller;

import com.maizi.fund.model.domain.AggreementLocation;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:18 下午
 */
@Controller
@RequestMapping("/mz1")
public class AggreementLocationController {


    @Autowired
    private HttpServletResponse response;


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
                                        @RequestParam(name = "user_id", required = false) String userId,
                                        @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                        @RequestParam(name = "id_num", required = false) String idNum){

        List<AggreementLocation> aggreementLocations = invtCashGuideService.selectAggreementLocations(userId, mobileNum, idNum);
        //System.out.println(aggreementLocations.get(0));
        map.addAttribute("aggreementLocations",aggreementLocations);

        return "aggreement_location";

    }

    @GetMapping("/fund/serchAggreementLocationList")
    @ResponseBody
    public Map<String, List> getAggreementLocationList(
                                                         @RequestParam(name = "user_id", required = false) String userId,
                                                         @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                                         @RequestParam(name = "id_num", required = false) String idNum){


        List<AggreementLocation> aggreementLocations = invtCashGuideService.selectAggreementLocations(userId, mobileNum, idNum);

        System.out.println(aggreementLocations.size());
        HashMap<String, List> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("aggreementLocations", aggreementLocations);

        return objectObjectHashMap;

    }

    @GetMapping("/fund/download")
    @ResponseBody
    public String getDownloadExcel(ModelMap map,
                                   @RequestParam(name = "user_id", required = false) String userId,
                                   @RequestParam(name = "mobile_num", required = true) String mobileNum,
                                   @RequestParam(name = "id_num", required = false) String idNum) {

        HSSFWorkbook allInfoExcel = invtCashGuideService.createAggreementLocationExcel(userId,mobileNum,idNum);

        String fileName = userId.isEmpty()?mobileNum:userId;


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
