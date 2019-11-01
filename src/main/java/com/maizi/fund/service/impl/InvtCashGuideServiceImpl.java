package com.maizi.fund.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.maizi.fund.mapper.InvtCashGuideMapper;
import com.maizi.fund.model.domain.AggreementLocation;
import com.maizi.fund.model.domain.InvtCashGuideDO;
import com.maizi.fund.model.domain.RechargeDetailDO;
import com.maizi.fund.model.domain.WithdrawDetailDO;
import com.maizi.fund.service.InvtCashGuideService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 4:16 下午
 */
@Service(value = "invtCashGuideService")
public class InvtCashGuideServiceImpl implements InvtCashGuideService {

    //缓存基本信息
    private Cache<String,InvtCashGuideDO> userInfoCache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();

    //缓存历史充值明细
    private Cache<String,List<RechargeDetailDO>> rechargeDetailCache = CacheBuilder.newBuilder().expireAfterAccess(5,TimeUnit.MINUTES).build();


    //缓存历史提现明细
    private Cache<String,List<WithdrawDetailDO>> withdrawDetailCache = CacheBuilder.newBuilder().expireAfterAccess(5,TimeUnit.MINUTES).build();

    //缓存债转协议链接列表
    private Cache<String,List<AggreementLocation>> aggreementLocationCache = CacheBuilder.newBuilder().expireAfterAccess(5,TimeUnit.MINUTES).build();


    @Autowired
    private InvtCashGuideMapper invtCashGuideMapper;




    @Override
    public InvtCashGuideDO selectIvt(String mobileNum, String idNum,String selectTime) {

        String key = (mobileNum.isEmpty()?idNum:mobileNum)+selectTime;


        InvtCashGuideDO invtCashGuideDO = userInfoCache.getIfPresent(key);

        if(invtCashGuideDO == null){
            invtCashGuideDO = invtCashGuideMapper.selectIvt(mobileNum, idNum,selectTime);
            if(invtCashGuideDO != null) {
                userInfoCache.put(key, invtCashGuideDO);
            }
        }


        System.out.println("2229999" + invtCashGuideDO);
        return invtCashGuideDO;
    }

    @Override
    public List<RechargeDetailDO> selectRechargeDetail(String mobileNum, String idNum,String selectTime) {

        String key = (mobileNum.isEmpty()?idNum:mobileNum)+selectTime;

        List<RechargeDetailDO>  rechargeDetail = rechargeDetailCache.getIfPresent(key);

        if(rechargeDetail==null){
            rechargeDetail=invtCashGuideMapper.selectRechargeDetail(mobileNum, idNum,selectTime);
            if(rechargeDetail!= null) {
                rechargeDetailCache.put(key, rechargeDetail);
            }
        }

        return rechargeDetail;
    }

    @Override
    public List<WithdrawDetailDO> selectWithdrawDetail(String mobileNum, String idNum,String selectTime) {

        String key = (mobileNum.isEmpty()?idNum:mobileNum)+selectTime;

        List<WithdrawDetailDO> withdrawDetail = withdrawDetailCache.getIfPresent(key);

        if(withdrawDetail==null){
            withdrawDetail=invtCashGuideMapper.selectWithdrawDetail(mobileNum, idNum,selectTime);
            if(withdrawDetail != null) {
                withdrawDetailCache.put(key, withdrawDetail);
            }
        }


        return withdrawDetail;
    }





    @Override
    public HSSFWorkbook createAllInfoExcel(String mobileNum, String idNum,String selectTime){
        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel

        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 新建单元格样式
        cellStyle.setFillForegroundColor((short) 0);// 设置背景色
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

        //设置边框
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

        //设置用户详情页
        HSSFSheet userInfoSheet = workbook.createSheet("用户详情");// 新建sheet页

        InvtCashGuideDO invtCashGuideDO = selectIvt(mobileNum, idNum,selectTime);
        setUserInfo(userInfoSheet,cellStyle,invtCashGuideDO,selectTime);


        //设置用户充值明细页
        HSSFSheet rechargeDetailSheet = workbook.createSheet("历史充值明细");
        List<RechargeDetailDO> rechargeDetailDOS = selectRechargeDetail(mobileNum, idNum,selectTime);
        setRechargeDetail(rechargeDetailSheet,cellStyle,rechargeDetailDOS);

        //设置用户提现明细页
        HSSFSheet withdrawDetailSheet = workbook.createSheet("历史提现明细");
        List<WithdrawDetailDO> withdrawDetailDOS = selectWithdrawDetail(mobileNum, idNum,selectTime);
        setWithdrawDetail(withdrawDetailSheet,cellStyle,withdrawDetailDOS);

        // 输出到本地
        //String excelName = "myExcel.xls";
        //FileOutputStream out = null;
        //try {
        //    out = new FileOutputStream(excelName);
        //    workbook.write(out);
        //    out.flush();
        //    out.close();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //} finally {
        //    if (out != null)
        //        try {
        //            out.close();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        //    out = null;
        //    System.out.println("导出成功");
        //}

        return workbook;

    }

    //设置用户详情页
    public void setUserInfo(HSSFSheet sheet ,HSSFCellStyle cellStyle,InvtCashGuideDO invtCashGuideDO,String selectTime){
        sheet.setColumnWidth(0,20*256);
        sheet.setColumnWidth(1,40*256);


        //客户姓名：杨*
        //realName;
        setRow(sheet,cellStyle,0,"客户姓名",invtCashGuideDO.getRealName());

        //证件号码：340881********5930
        //idNum;
        setRow(sheet,cellStyle,1,"证件号码", invtCashGuideDO.getIdNum());

        //手机号：131****8198
        //mobileNum;
        setRow(sheet,cellStyle,2,"手机号", invtCashGuideDO.getMobileNum());

        //注册时间：2014-09-01 12:00:19.0
        //registerTime;
        setRow(sheet,cellStyle,3,"注册时间", invtCashGuideDO.getRegisterTime());

        //当前余额：13.35 元
        //biSevenBalance;
        setRow(sheet,cellStyle,4,"当前余额", invtCashGuideDO.getBiSevenBalance());

        //充值笔数：65
        //rechargeCnt;
        setRow(sheet,cellStyle,5,"充值笔数", invtCashGuideDO.getRechargeCnt());

        //充值金额：410,598.80 元
        //biRechargeSum;
        setRow(sheet,cellStyle,6,"充值金额", invtCashGuideDO.getBiRechargeSum());

        //待匹配债权金额：0.00 元
        //biThirteenBalance;
        setRow(sheet,cellStyle,7,"待匹配债权金额", invtCashGuideDO.getBiThirteenBalance());

        //提现笔数：23
        //withdrawCnt;
        setRow(sheet,cellStyle,8,"提现笔数", invtCashGuideDO.getWithdrawCnt());

        //提现总额：430,692.56 元
        //biWithdrawSum;
        setRow(sheet,cellStyle,9,"提现总额", invtCashGuideDO.getBiWithdrawSum());

        //财神原账户：0.58 元
        //biCsBalance;
        setRow(sheet,cellStyle,10,"财神原账户", invtCashGuideDO.getBiCsBalance());

        //债转折扣让利总额：0.61 元
        //biTransferLoss;
        setRow(sheet,cellStyle,11,"债转折扣让利总额", invtCashGuideDO.getBiTransferLoss());

        //剩余充值本金：-20,108.30 元
        //biOriginalCapital;
        setRow(sheet,cellStyle,12,"剩余充值本金", invtCashGuideDO.getBiOriginalCapital());

        //匹配债权金额：0.00 元
        //biDebtCapitalSum
        setRow(sheet,cellStyle,13,"匹配债权金额", invtCashGuideDO.getBiDebtCapitalSum());
        //匹配债权金额(八折)：0.00 元
        //biDebtCapitalSumEight
        //setRow(sheet,cellStyle,14,"匹配债权金额(八折)", invtCashGuideDO.getBiDebtCapitalSumEight());

        setRow(sheet,cellStyle,14,"快照日期", selectTime);

    }

    /*
        添加一行两列的数据
     */
    public void setRow(HSSFSheet sheet,HSSFCellStyle cellStyle,int rowNumber,String key,String value){
        HSSFRow titleRow = sheet.createRow(rowNumber);

        Cell keyCell=titleRow.createCell(0);
        keyCell.setCellValue(key);
        keyCell.setCellStyle(cellStyle);

        Cell valueCell=titleRow.createCell(1);
        valueCell.setCellValue(value);
        valueCell.setCellStyle(cellStyle);
    }

    //历史充值明细
    public void setRechargeDetail(HSSFSheet sheet ,HSSFCellStyle cellStyle,List<RechargeDetailDO> rechargeDetailDOS){
        sheet.setColumnWidth(0,15*256);
        sheet.setColumnWidth(1,30*256);
        sheet.setColumnWidth(2,20*256);
        HSSFRow topRow = sheet.createRow(0);
        Cell c0 = topRow.createCell(0);
        c0.setCellStyle(cellStyle);
        c0.setCellValue("充值笔数");
        Cell c1 = topRow.createCell(1);
        c1.setCellStyle(cellStyle);
        c1.setCellValue("充值时间");
        Cell c2 = topRow.createCell(2);
        c2.setCellStyle(cellStyle);
        c2.setCellValue("充值金额(元)");

        int i=1;
        for(RechargeDetailDO rdd:rechargeDetailDOS){
            HSSFRow row = sheet.createRow(i);

            Cell cl0 = row.createCell(0);
            cl0.setCellStyle(cellStyle);
            cl0.setCellValue(rdd.getRechargeCnt());
            Cell cl1 = row.createCell(1);
            cl1.setCellStyle(cellStyle);
            cl1.setCellValue(rdd.getRechargeTime());
            Cell cl2 = row.createCell(2);
            cl2.setCellStyle(cellStyle);
            cl2.setCellValue(rdd.getRechargeAmount());

            i++;
        }

    }



    //历史提现明细
    public void setWithdrawDetail(HSSFSheet sheet ,HSSFCellStyle cellStyle,List<WithdrawDetailDO> withdrawDetailDOS){
        sheet.setColumnWidth(0,15*256);
        sheet.setColumnWidth(1,10*256);
        sheet.setColumnWidth(2,30*256);
        sheet.setColumnWidth(3,20*256);
        HSSFRow topRow = sheet.createRow(0);
        Cell c0 = topRow.createCell(0);
        c0.setCellStyle(cellStyle);
        c0.setCellValue("提现笔数");
        Cell c1 = topRow.createCell(1);
        c1.setCellStyle(cellStyle);
        c1.setCellValue("类型");
        Cell c2 = topRow.createCell(2);
        c2.setCellStyle(cellStyle);
        c2.setCellValue("提现时间");
        Cell c3 = topRow.createCell(3);
        c3.setCellStyle(cellStyle);
        c3.setCellValue("提现金额(元)");

        int i=1;
        for(WithdrawDetailDO wdd:withdrawDetailDOS){
            HSSFRow row = sheet.createRow(i);

            Cell cl0 = row.createCell(0);
            cl0.setCellStyle(cellStyle);
            cl0.setCellValue(wdd.getWithdrawCnt());
            Cell cl1 = row.createCell(1);
            cl1.setCellStyle(cellStyle);
            cl1.setCellValue(wdd.getWithdrawType());
            Cell cl2 = row.createCell(2);
            cl2.setCellStyle(cellStyle);
            cl2.setCellValue(wdd.getWithdrawTime());
            Cell cl3 = row.createCell(3);
            cl3.setCellStyle(cellStyle);
            cl3.setCellValue(wdd.getWithdrawAmount());

            i++;
        }


    }


    @Override
    public  List<AggreementLocation> selectAggreementLocations(String userId, String mobileNum, String idNum){

        String key = userId.isEmpty()?mobileNum:userId;

        List<AggreementLocation> aggreementLocationList = aggreementLocationCache.getIfPresent(key);

        if(aggreementLocationList == null){
            aggreementLocationList = invtCashGuideMapper.selectAggreementLocation(userId,mobileNum);

            if(aggreementLocationList != null){
                aggreementLocationCache.put(key,aggreementLocationList);
            }
        }

        return aggreementLocationList;
    }

    @Override
    public HSSFWorkbook createAggreementLocationExcel(String userId, String mobileNum, String idNum) {

        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel

        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 新建单元格样式
        cellStyle.setFillForegroundColor((short) 0);// 设置背景色
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

        //设置边框
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

        //债转协议详细列表
        HSSFSheet sheet = workbook.createSheet("债转协议详细列表");// 新建sheet页

        //设置列宽
        sheet.setColumnWidth(0,40*256);
        sheet.setColumnWidth(1,20*256);
        sheet.setColumnWidth(2,20*256);
        sheet.setColumnWidth(3,15*256);
        sheet.setColumnWidth(4,20*256);
        sheet.setColumnWidth(5,25*256);
        sheet.setColumnWidth(6,100*256);
        HSSFRow topRow = sheet.createRow(0);
        Cell c0 = topRow.createCell(0);
        c0.setCellStyle(cellStyle);
        c0.setCellValue("流水号");
        Cell c1 = topRow.createCell(1);
        c1.setCellStyle(cellStyle);
        c1.setCellValue("原始在投本金(元)");
        Cell c2 = topRow.createCell(2);
        c2.setCellStyle(cellStyle);
        c2.setCellValue("当前债权(元)");
        Cell c3 = topRow.createCell(3);
        c3.setCellStyle(cellStyle);
        c3.setCellValue("已债转金额(元)");
        Cell c4 = topRow.createCell(4);
        c4.setCellStyle(cellStyle);
        c4.setCellValue("回款金额(元)");
        Cell c5 = topRow.createCell(5);
        c5.setCellStyle(cellStyle);
        c5.setCellValue("时间");
        Cell c6 = topRow.createCell(6);
        c6.setCellStyle(cellStyle);
        c6.setCellValue("协议");

        List<AggreementLocation> aggreementLocations = selectAggreementLocations(userId, mobileNum, idNum);

        int i=1;
        for(AggreementLocation als : aggreementLocations){
            HSSFRow row = sheet.createRow(i);


            Cell cl0 = row.createCell(0);
            cl0.setCellStyle(cellStyle);
            cl0.setCellValue(als.getTransId());

            Cell cl1 = row.createCell(1);
            cl1.setCellStyle(cellStyle);
            cl1.setCellValue(als.getOriginalPrice());

            Cell cl2 = row.createCell(2);
            cl2.setCellStyle(cellStyle);
            cl2.setCellValue(als.getPrice());

            Cell cl3 = row.createCell(3);
            cl3.setCellStyle(cellStyle);
            cl3.setCellValue(als.getTransferPrice());

            Cell cl4 = row.createCell(4);
            cl4.setCellStyle(cellStyle);
            cl4.setCellValue(als.getRepayPrice());

            Cell cl5 = row.createCell(5);
            cl5.setCellStyle(cellStyle);
            cl5.setCellValue(als.getAggreementTime());

            Cell cl6 = row.createCell(6);
            cl6.setCellStyle(cellStyle);
            cl6.setCellValue(als.getAggreementLocation());

            i++;
        }


        return workbook;
    }
}
