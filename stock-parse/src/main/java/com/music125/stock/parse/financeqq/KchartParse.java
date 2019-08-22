package com.music125.stock.parse.financeqq;


import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music125.stock.utils.ParseUtils;

import java.util.List;

/**
 * @Desc k线图
 */
//@Slf4j
public class KchartParse {


    private static String url="http://proxy.finance.qq.com/ifzqgtimg/appstock/app/newfqkline/get?p=1&param=%s,day,,,370,qfq";



    public static void parse(String code){
        try {
            url = String.format(url,code);

            String jsonResult = HttpClientUtil.get(HttpConfig.custom().url(url));

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResult);
            List<String> kdata = ParseUtils.getStringList(rootNode, "qfqday");



            System.out.println(kdata);

//            if(StringUtils.isNoneBlank(kdata)){
//
//                if(StringUtils.isNoneBlank(kdata)){
//
//                    KchartResponse kcharResult = JSON.parseObject(kdata, KchartResponse.class);
//
//                    System.out.println(kcharResult);
//                }
//            }


        }catch (Exception e){

            System.out.println(e);
            //log.error("获取设备类型失败，异常={}",httpException);
        }
    }

    public static void main(String[] args){
        parse("sz000839");
    }


}
