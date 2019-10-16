package com.maizi.fund.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/15 9:25 上午
 */
public class NumberFormatUtils {
    private static DecimalFormat df = new DecimalFormat("#,##0.00");

    private static NumberFormatUtils instance;

    private NumberFormatUtils(){}

    public static NumberFormatUtils getInstance() {
        if (instance == null) {
            return new NumberFormatUtils();
        }
        return instance;
    }

    public String formatNum(String number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return df.format(bigDecimal);
    }

    public String replaceNameX(String str){
        String reg = ".{1}";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int i = 0;
        while(m.find()){
            i++;
            if(i==1) {
                continue;
            }
            m.appendReplacement(sb, "*");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
