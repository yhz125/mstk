/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.core.manager.convert;

import com.music125.stock.biz.dal.model.CompanyDO;
import com.music125.stock.bo.StockCodeBO;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-29 11:12
 */
public class StockCompanyConverter {

    public static CompanyDO convertBO2DO(StockCodeBO bo){
        if(bo==null){
            return null;
        }
        CompanyDO result = new CompanyDO();
        result.setStockCode(bo.getCode());
        result.setName(bo.getName());
        result.setStockExchange(bo.getExchange());
        return result;
    }

    public static List<CompanyDO> convertListBO2DO(List<StockCodeBO> list){
        if(list==null){
            return null;
        }
        List<CompanyDO> result = new ArrayList<>();
        for (StockCodeBO bo:list) {
            result.add(convertBO2DO(bo));
        }
        return result;
    }
}
