package com.music125.stock.utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yinhz on 2019-05-15.
 * @Desc 搜索工具类
 */
public class ParseUtils {

    public final static String NULL = "null";

    /**
     * List<String>转换成逗号分隔符类型
     *
     * @param <T>
     * @param idList
     * @return
     */
    public static <T> String convertSplitId(List<T> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return "";
        }
        return StringUtils.join(idList, ",");
    }


    public static String getStringValue(JsonNode jo, String name, String defaultValue) {

        String value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).asText();
                if (StringUtils.isBlank(value) || NULL.equals(value)) {
                    value = defaultValue;
                }
            } catch (Exception e) {
//                LOGGER.error("获取json对象:{},异常message:{}", name , e.getMessage(), e);
            }
        }
        return value;
    }
    public static String getStringValues(JsonNode jo, String name, String defaultValue) {
        String value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                JsonNode jsonNode = jo.get(name);
                value = jsonNode.toString();
                if (StringUtils.isBlank(value) || NULL.equals(value)) {
                    value = defaultValue;
                }
            } catch (Exception e) {
//                LOGGER.error("获取json对象:{},异常message:{}", name , e.getMessage(), e);
            }
        }
        return value;
    }


    public static String overHeadTail(String string){
        if(StringUtils.isBlank(string)){
            return string;
        }
        if(string.length()< 2){
            return string;
        }
        return  string.substring(1,string.length()-2);
    }

    public static int getIntValue(JsonNode jo, String name, int defaultValue) {
        int value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).asInt();
            } catch (Exception e) {
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return value;
    }

    public static double getDoubleValue(JsonNode jo, String name, double defaultValue) {
        double value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).asDouble();
            } catch (Exception e) {
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return value;
    }

    public static long getLongValue(JsonNode jo, String name, long defaultValue) {
        long value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).asLong();
            } catch (Exception e) {
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return value;
    }

    public static BigDecimal getDecimalValue(JsonNode jo, String name, BigDecimal defaultValue) {
        BigDecimal value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).decimalValue();
            } catch (Exception e) {
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return value;
    }

    public static Boolean getBooleanFromJO(JsonNode jo, String name, Boolean defaultValue) {
        Boolean value = defaultValue;
        if (jo.has(name) && !jo.get(name).isNull()) {
            try {
                value = jo.get(name).asBoolean();
            } catch (Exception e) {
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return value;
    }

    public static List<String> getStringList(JsonNode jo, String name) {
        List<String> scs = null;
        if (jo.has(name)) {
            try {
                scs = new ArrayList<String>();
                Iterator<JsonNode> iterator = jo.get(name).elements();
                while (iterator.hasNext()) {
                    scs.add(iterator.next().asText());
                }
            } catch (Exception e) {
                scs = null;
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return scs;
    }

    /**
     * @dec 根据某个分隔符，转换list
     * @param jo
     * @param name
     * @param sparator
     * @return
     */
    public static List<String> getStringListSplit(JsonNode jo,String name,String sparator){
        List<String> scs = null;
        if (jo.has(name)&& !jo.get(name).isNull()){
            try{
                String values =getStringValue(jo,name,"");
                scs = Arrays.asList(values.split(sparator));
            }catch (Exception e){
                scs = null;
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return scs;
    }

    public static Map<String, Integer> getMapFromJO(JsonNode jo, String name) {
        Map<String, Integer> map = null;
        if (jo.has(name)) {
            try {
                map = new HashMap<String, Integer>();
                Iterator<JsonNode> iterator = jo.get(name).elements();
                while (iterator.hasNext()) {
                    String[] temArr = iterator.next().asText().split("\\|");
                    map.put(temArr[0], Integer.parseInt(temArr[1]));
                }
            } catch (Exception e) {
                map = null;
//                LOGGER.error("获取json对象[" + name + "]异常：" + e.getMessage(), e);
            }
        }
        return map;
    }

    /**
     * @param q 搜索字符串
     * @return 返回截取后字符串
     */
    public static String getQ(String q) {
        return abbrStr(q, 50);
    }

    /**
     * 将字符串按照最大长度截断
     *
     * @param str    原字符串
     * @param maxLen 保留字符串的最大长度
     * @return 截断后的字符串，如果原字符串为null，则返回空字符串
     */
    public static String abbrStr(String str, int maxLen) {
        String result = "";
        if (StringUtils.isNotBlank(str)) {
            int len = str.length();
            if (len > maxLen) {
                result = str.substring(0, maxLen);
            } else {
                result = str;
            }
        }
        return result;
    }
}