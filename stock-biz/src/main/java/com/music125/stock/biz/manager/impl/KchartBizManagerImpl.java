package com.music125.stock.biz.manager.impl;

import com.music125.stock.biz.dal.KchartMapper;
import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.biz.manager.KchartBizManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;


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
     * @param list
     */
    @Override
    public void insert(List<KchartDO> list) {


        try {
            Integer acc = kchartMapper.insert(list);

            System.out.println("入库状态:" + acc);
        }

        catch (Exception ex){
            System.out.println(ex);
        }

    }

    /**
     * 查询所有最新数据
     *
     * @return
     */
    @Override
    public List<KchartDO> getAllLastKchart() {
        return kchartMapper.queryAllLastKchart();
    }
}
