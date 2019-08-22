package com.music125.stock.stockweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.music125.stock.biz.manager"})
@MapperScan(basePackages = { "com.music125.stock.biz.dal" })
public class StockWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockWebApplication.class, args);
    }

}
