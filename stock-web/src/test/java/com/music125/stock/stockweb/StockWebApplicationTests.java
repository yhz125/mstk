package com.music125.stock.stockweb;

import com.music125.stock.core.manager.KchartManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockWebApplicationTests {

    @Resource
    private KchartManager kchartManager;
    @Test
    public void contextLoads() {
        kchartManager.insert();
    }



}
