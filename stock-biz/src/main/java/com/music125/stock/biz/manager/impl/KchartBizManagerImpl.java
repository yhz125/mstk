package com.music125.stock.biz.manager.impl;

import com.music125.stock.biz.dal.KchartMapper;
import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.biz.manager.KchartBizManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;


/**
 * Kchart
 */

@Service
@Slf4j
@Validated
public class KchartBizManagerImpl implements KchartBizManager {



    @Resource
    private KchartMapper kchartMapper;
    /**
     * 保存k线图
     *
     * @param kchartDO
     */
    @Override
    public void insert(KchartDO kchartDO) {

        kchartMapper.insert(kchartDO);

        System.out.println("KchartManagerImpl");
    }
}
