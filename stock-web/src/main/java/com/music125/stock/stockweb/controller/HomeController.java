package com.music125.stock.stockweb.controller;


//import com.music125.stock.biz.dal.model.LogDO;
//import com.music125.stock.biz.manager.LogManager;
//import com.music125.stock.core.T2;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {





    @RequestMapping(value = "/gettime",method = RequestMethod.GET)
    public long getTime(){


//        T2 t2 = new T2();
//        t2.a();

        return System.currentTimeMillis();
    }
}
