package com.music125.stock.parse.financeqq;


import com.alibaba.fastjson.JSON;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music125.stock.parse.financeqq.response.KchartResponse;
import com.music125.stock.utils.ParseUtils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc k线图
 */
@Slf4j
public class KchartParse {


    private static String url="http://proxy.finance.qq.com/ifzqgtimg/appstock/app/newfqkline/get?p=1&param=%s,day,,,370,qfq";



    public static void parse(String code){
        try {

            url = String.format(url,code);

            String jsonResult = HttpClientUtil.get(HttpConfig.custom().url(url));

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResult);
            String kdata = ParseUtils.getValueToString(rootNode, "data","");
            rootNode = mapper.readTree(kdata);
            kdata = ParseUtils.getValueToString(rootNode, code,"");

            System.out.println(kdata);

            if(StringUtils.isNoneBlank(kdata)){

                KchartResponse kcharResult = JSON.parseObject(kdata, KchartResponse.class);
                if(kcharResult!=null && !CollectionUtils.isEmpty(kcharResult.qfqday)){
                    for (List<Object> kchartItems:kcharResult.qfqday) {
                        kchartItems.get(0);
                    }
                }
            }


        }catch (Exception e){

            System.out.println(e);
            //log.error("获取设备类型失败，异常={}",httpException);
        }
    }

    public static void main(String[] args){
        parse("sz000839");
    }


}
