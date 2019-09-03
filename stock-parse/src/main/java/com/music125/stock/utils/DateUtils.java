/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.utils;

import java.text.ParseException;
import java.util.Date;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-09-03 18:56
 */
public class DateUtils {

    public static final String FORMAT_DATE_YMD = "yyyy-MM-dd";

    /**
     * 格式化
     *
     * @param strDateTime
     * @param pattern
     * @return Date
     */
    public static Date parseDate(String strDateTime, String pattern) {
        try {
            return org.apache.commons.lang.time.DateUtils.parseDate(strDateTime, new String[]{pattern});
        } catch (ParseException e) {
//            logger.error("格式化日期出错，date=" + strDateTime, e);
            return null;
        }
    }
}
