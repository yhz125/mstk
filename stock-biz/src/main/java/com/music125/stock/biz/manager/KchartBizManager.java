package com.music125.stock.biz.manager;

import com.music125.stock.biz.dal.model.KchartDO;

public interface KchartBizManager {

    /**
     * 保存k线图
     *
     * @param kchartDO
     */
    void insert(KchartDO kchartDO) ;
}
