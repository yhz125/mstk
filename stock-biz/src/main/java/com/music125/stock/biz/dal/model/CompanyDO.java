package com.music125.stock.biz.dal.model;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyDO {

    Integer id;

    /**
     * sh/sz
     */
    String stockExchange;

    /**
     * 证券代码
     */
    String stockCode;

}
