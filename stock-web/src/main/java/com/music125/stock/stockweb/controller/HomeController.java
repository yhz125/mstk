package com.music125.stock.stockweb.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/home")
public class HomeController {






    @RequestMapping(value = "/gettime",method = RequestMethod.GET)
    public long getTime(){

        System.out.println("tttt");
        return System.currentTimeMillis();
    }
}
