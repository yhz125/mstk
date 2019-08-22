/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.biz.dal;

import com.music125.stock.biz.dal.model.KchartDO;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-22 17:36
 */
public interface KchartMapper {


    /**
     * 对象入库
     *
     * @param kchartDO 日志 入库对象
     * @return 入库数目
     */
    Integer insert(KchartDO kchartDO);
}
