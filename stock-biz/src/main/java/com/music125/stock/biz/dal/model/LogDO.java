/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock.biz.dal.model;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-22 17:52
 */

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author initializr
 * @version 1.0
 * @since 2019-07-29
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogDO {
    /**
     * 主键
     */
    Long id;

    /**
     * 操作人
     */
    String operator;

    /**
     * 操作类型
     */
    String operationType;

    /**
     * 操作数据
     */
    String operationData;

    /**
     * 创建时间
     */
    LocalDateTime gmtCreated;

    /**
     * 最后修改时间
     */
    LocalDateTime gmtModified;

    /**
     * 是否删除；0--否，1--是
     */
    Integer isDelete;
}
