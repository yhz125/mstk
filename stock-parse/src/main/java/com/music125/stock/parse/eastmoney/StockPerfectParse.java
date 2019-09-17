/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.parse.eastmoney;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.music125.stock.bo.StockCodeBO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-29 11:02
 */
public class StockPerfectParse {

    private static String url="http://quote.eastmoney.com/stock_list.html";

    public static List<StockCodeBO> parse(){
        try {
            List<StockCodeBO> list = new ArrayList<>();
            String htmlSource = HttpClientUtil.get(HttpConfig.custom().url(url).encoding("gb2312"));
            String s = "quote.eastmoney.com/s(.*?).html\">(.*?)\\(";
            Pattern pattern= Pattern.compile(s);
            Matcher ma=pattern.matcher(htmlSource);

            while(ma.find()){
                StockCodeBO bo = new StockCodeBO();
                bo.setExchange("s"+ma.group(1).substring(0,1));
                bo.setCode(ma.group(1).substring(1));
                bo.setName(ma.group(2));
                list.add(bo);
            }
            return list;

        }catch (Exception ex){
            return null;
        }
    }

}
