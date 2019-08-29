/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.biz.dal;

import com.music125.stock.biz.dal.model.CompanyDO;
import com.music125.stock.biz.dal.model.KchartDO;

import java.util.List;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-22 17:36
 */
public interface CompanyMapper {


    /**
     * 对象入库
     *
     * @param list 日志 入库对象
     * @return 入库数目
     */
    Integer insert(List<CompanyDO> list);

    /**
     * 返回所有公司
     * @return
     */
    List<CompanyDO> listAllCompany();
}
