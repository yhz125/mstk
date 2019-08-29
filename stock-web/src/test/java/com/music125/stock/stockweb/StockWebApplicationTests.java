package com.music125.stock.stockweb;

import com.music125.stock.core.manager.KchartManager;
import com.music125.stock.core.manager.StockCompayManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class StockWebApplicationTests {

    @Resource
    private KchartManager kchartManager;

    @Resource
    private StockCompayManager stockCompayManager;

    @Test
    public void allStockCodeTest(){
        stockCompayManager.crawlerStockFill();

    }

    @Test
    public void crawlerKchartFill(){
        kchartManager.crawlerKchartFill(true);
    }



}
