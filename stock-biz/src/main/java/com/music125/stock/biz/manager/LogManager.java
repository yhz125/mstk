/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.biz.manager;

import com.music125.stock.biz.dal.model.LogDO;
import com.sun.istack.internal.NotNull;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-22 18:01
 */
public interface LogManager {

    /**
     * 日志记录对象入库
     *
     * @param logBO 日志记录
     */
    void save(@NotNull @Valid LogDO logBO);
}
