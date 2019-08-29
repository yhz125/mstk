package com.music125.stock.biz.manager;

import com.music125.stock.biz.dal.model.CompanyDO;

import java.util.List;

public interface CompanyBizManager {

    /**
     * 保存所有code
     *
     * @param list
     */
    void insert(List<CompanyDO> list) ;

    /**
     * 返回所有公司
     * @return
     */
    List<CompanyDO> getAllList();
}
