/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.parse.eastmoney;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.springframework.util.CollectionUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-27 19:19
 */
@PipelineName(value="stockPipelines")
public class StockPipelines   implements Pipeline<AllStockParse> {

    /**
     * 将抓取到的内容进行处理  这里是打印在控制台
     */
    @Override
    public void process(AllStockParse stock) {

        if(stock!=null && !CollectionUtils.isEmpty(stock.getStocks())){
            String s = "quote.eastmoney.com/(.*?).html";
            for (String li:stock.getStocks()) {
                Pattern  pattern= Pattern.compile(s);
                Matcher ma=pattern.matcher(li);

                while(ma.find()){
                    System.out.println(ma.group(1));
                }
            }
        }

    }
}
