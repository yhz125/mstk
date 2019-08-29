package com.music125.stock.biz.manager.impl;

import com.music125.stock.biz.dal.CompanyMapper;
import com.music125.stock.biz.dal.model.CompanyDO;
import com.music125.stock.biz.manager.CompanyBizManager;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;

/**
 * Kchart
 */

@Service
@Slf4j
@Validated
public class CompanyBizManagerImpl implements CompanyBizManager {



    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 保存所有code
     *
     * @param list
     */
    @Override
    public void insert(List<CompanyDO> list) {

        companyMapper.insert(list);

    }

    /**
     * 返回所有公司
     *
     * @return
     */
    @Override
    public List<CompanyDO> getAllList() {
        return companyMapper.listAllCompany();
    }
}
