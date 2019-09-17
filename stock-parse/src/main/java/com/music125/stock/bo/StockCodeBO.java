package com.music125.stock.bo;


import lombok.Data;

@Data
public class StockCodeBO {

    /**
     * 代码
     */
    private String code;


    /**
     * 地点(sf,sz)
     */
    private String exchange;

    /**
     * 名称
     */
    String name;



}
