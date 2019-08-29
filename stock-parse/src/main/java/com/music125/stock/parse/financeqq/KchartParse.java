package com.music125.stock.parse.financeqq;


import com.alibaba.fastjson.JSON;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music125.stock.bo.KchartBO;
import com.music125.stock.parse.financeqq.response.KchartResponse;
import com.music125.stock.utils.ParseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc k线图
 */
@Slf4j
public class KchartParse {

    public static List<KchartBO> parse(String code,int days){
        String url="http://proxy.finance.qq.com/ifzqgtimg/appstock/app/newfqkline/get?p=1&param=%s,day,,,%d,qfq";
        try {

            url = String.format(url,code,days);

            String jsonResult = HttpClientUtil.get(HttpConfig.custom().url(url));

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResult);
            String kdata = ParseUtils.getValueToString(rootNode, "data","");
            rootNode = mapper.readTree(kdata);
            kdata = ParseUtils.getValueToString(rootNode, code,"");
            System.out.println(code);
            System.out.println(kdata);

            if(StringUtils.isNoneBlank(kdata)){
                List<KchartBO> list = new ArrayList<>();
                KchartResponse kcharResult = JSON.parseObject(kdata, KchartResponse.class);
                if(kcharResult!=null && !CollectionUtils.isEmpty(kcharResult.qfqday)){
                    BigDecimal yesterdayClosingPrice = new BigDecimal(0.01);
                    for (List<Object> kchartItems:kcharResult.qfqday) {

                        KchartBO bo = new KchartBO();
                        bo.setStockCode(code.replaceAll("sz","").replaceAll("sh",""));
                        bo.setSourceId(1);
                        bo.setDate(kchartItems.get(0).toString());
                         //上一天收盘价
                        bo.setYesterdayClosingPrice(yesterdayClosingPrice);
                        //开盘价
                        bo.setOpeningPrice(new BigDecimal(kchartItems.get(1).toString()));
                        //收盘价
                        bo.setClosingPrice(new BigDecimal(kchartItems.get(2).toString()));
                        //最高价
                        bo.setHighPrice(new BigDecimal(kchartItems.get(3).toString()));
                        //最低价
                        bo.setLowPrice(new BigDecimal(kchartItems.get(4).toString()));
                        //成交量
                        bo.setTradingVolume(new BigDecimal(kchartItems.get(5).toString()));
                        //换手率
                        bo.setTurnoverRate(new BigDecimal(kchartItems.get(7).toString()));
                        //交易额
                        bo.setTurnover(new BigDecimal(kchartItems.get(8).toString()));
                        if(new BigDecimal(0.00).equals(bo.getClosingPrice())){
                            bo.setClosingPrice(new BigDecimal(0.01));
                        }
                        yesterdayClosingPrice = bo.getClosingPrice();

                        list.add(bo);
                    }
                    return list;
                }
            }


        }catch (Exception e){

            System.out.println(e);
            //log.error("获取设备类型失败，异常={}",httpException);
        }
        return null;
    }



}
