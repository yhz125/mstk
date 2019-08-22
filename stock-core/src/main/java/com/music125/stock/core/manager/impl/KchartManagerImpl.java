package com.music125.stock.core.manager.impl;

import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.biz.manager.KchartBizManager;
import com.music125.stock.bo.KchartBO;
import com.music125.stock.core.manager.KchartManager;
import com.music125.stock.core.manager.convert.KchartConverter;
import com.music125.stock.parse.financeqq.KchartParse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class KchartManagerImpl implements KchartManager {


    @Resource
    private KchartBizManager bizManager;

    @Override
    public void insert(KchartDO kchartDO) {

        List<KchartBO> list = KchartParse.parse("sz000839");
        if(!CollectionUtils.isEmpty(list)){

            List<KchartDO> doList = KchartConverter.convertListBO2DO(list);
            for (KchartDO item: doList) {
                bizManager.insert(item);

            }

        }

    }
}
