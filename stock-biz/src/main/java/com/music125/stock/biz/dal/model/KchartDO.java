package com.music125.stock.biz.dal.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class KchartDO {


    Integer id;

    /**
     * 证券代码
     */
    String stockCode;

    /**
     * 日期
     */
    String date;

    /**
     * 开盘价
     */
    BigDecimal openingPrice;

    /**
     * 收盘价
     */
    BigDecimal closingPrice;

    /**
     * 最高价
     */
    BigDecimal highPrice;

    /**
     * 最低价
     */
    BigDecimal lowPrice;

    /**
     * 成交量
     */
    BigDecimal tradingVolume;


    /**
     * 换手率
     */
    BigDecimal turnoverRate;

    /**
     * 成交额
     */
    BigDecimal turnover;

    /**
     * 昨天收盘价
     */
    BigDecimal yesterdayClosingPrice;

    /**
     * 1:腾讯
     */
    Integer sourceId;
}
