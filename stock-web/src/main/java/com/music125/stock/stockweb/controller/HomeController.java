package com.music125.stock.stockweb.controller;


import com.music125.stock.biz.dal.model.KchartDO;
import com.music125.stock.core.manager.KchartManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/home")
public class HomeController {


    @Resource
    private KchartManager kchartManager;



    @RequestMapping(value = "/gettime",method = RequestMethod.GET)
    public long getTime(){


        return System.currentTimeMillis();
    }
}
