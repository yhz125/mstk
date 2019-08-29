/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.core.manager.impl;

import com.geccocrawler.gecco.GeccoEngine;
import com.music125.stock.biz.dal.CompanyMapper;
import com.music125.stock.biz.manager.CompanyBizManager;
import com.music125.stock.bo.StockCodeBO;
import com.music125.stock.core.manager.StockCompayManager;
import com.music125.stock.core.manager.convert.StockCompanyConverter;
import com.music125.stock.parse.eastmoney.StockPerfectParse;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-28 14:13
 */
@Component
public class StockCompayManagerImpl implements StockCompayManager {

    @Resource
    private CompanyBizManager companyBizManager;
    /**
     * 采集stock
     */
    @Override
    public void crawlerStockFill() {
        List<StockCodeBO> list = StockPerfectParse.parse();
        if(!CollectionUtils.isEmpty(list)){
            companyBizManager.insert(StockCompanyConverter.convertListBO2DO(list));
        }
    }
}
