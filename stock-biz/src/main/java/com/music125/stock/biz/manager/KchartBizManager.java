package com.music125.stock.biz.manager;

import com.music125.stock.biz.dal.model.KchartDO;

import java.util.List;

public interface KchartBizManager {

    /**
     * 保存k线图
     *
     * @param list
     */
    void insert(List<KchartDO> list) ;
}
