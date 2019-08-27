package com.music125.stock.bo;


import lombok.Data;

@Data
public class StockCodeBO {

    /**
     * 代码
     */
    private String code;


    /**
     * 上市地点(sf,sz)
     */
    private String exchange;



}
