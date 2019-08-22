/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;

import com.music125.stock.biz.dal.KchartMapper;
import com.music125.stock.biz.dal.model.LogDO;
import com.music125.stock.biz.manager.LogManager;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-22 18:04
 */
@Service
@Slf4j
@Validated
public class LogManagerImpl implements LogManager {

    @Resource
    private KchartMapper logMapper;

    /**
     * 日志记录对象入库
     *
     * @param logBO 日志记录
     */
    @Override
    public void save(@Valid LogDO logBO) {
        logMapper.insert(logBO);
    }
}
