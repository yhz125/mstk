package com.music125.stock.core.manager.impl;

import com.music125.stock.biz.dal.model.CompanyDO;
import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.biz.manager.CompanyBizManager;
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

    @Resource
    private CompanyBizManager companyBizManager;




    /**
     * 批量更新
     *
     * @param isAll
     */
    @Override
    public void crawlerKchartFill(boolean isAll) {

        try {
            //默认获取的天数
            int kChartDay = 1000;
            List<CompanyDO> allStocks = companyBizManager.getAllList();
            if(!isAll){
                //近10天
                kChartDay=5;
            }
            int i =0;
            for (CompanyDO stock: allStocks) {
                String code = stock.getStockExchange()+stock.getStockCode();
                List<KchartBO> kChartList = KchartParse.parse(code,kChartDay,stock.getLastDate());
                List<KchartDO> doList = KchartConverter.convertListBO2DO(kChartList);
                if(!CollectionUtils.isEmpty(doList)){
                    bizManager.insert(doList);
                    System.out.println("stock:"+i);
                    i++;
                    //Thread.sleep(300);
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }



}
