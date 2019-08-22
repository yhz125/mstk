package com.music125.stock.core.manager.convert;

import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.bo.KchartBO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class KchartConverter {


    public static KchartDO convertBO2DO(KchartBO bo){
        if(bo==null){
            return null;
        }

        KchartDO result = new KchartDO();
        result.setDate(bo.getDate());
        result.setClosingPrice(bo.getClosingPrice());
        result.setHighPrice(bo.getHighPrice());
        result.setLowPrice(bo.getLowPrice());
        result.setOpeningPrice(bo.getOpeningPrice());
        result.setSourceId(bo.getSourceId());
        result.setStockCode(bo.getStockCode());
        result.setTradingVolume(bo.getTradingVolume());
        result.setTurnover(bo.getTurnover());
        result.setTurnoverRate(bo.getTurnoverRate());
        result.setYesterdayClosingPrice(bo.getYesterdayClosingPrice());
        return result;
    }


    public static List<KchartDO> convertListBO2DO(List<KchartBO> list){

        if(CollectionUtils.isEmpty(list)){
            return null ;
        }

        List<KchartDO> result = new ArrayList<>();
        for (KchartBO bo:list) {
            result.add(convertBO2DO(bo));
        }
        return  result;


    }

}
