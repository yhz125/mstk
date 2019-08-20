package com.music125.stock.stockweb.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {


    @Value("qting.kchart.url")
    private String url;

    @RequestMapping(value = "/gettime",method = RequestMethod.GET)
    public long getTime(){

        System.out.println(url);

        return System.currentTimeMillis();
    }
}
