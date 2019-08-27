package com.music125.stock.stockweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.music125.stock"})
@MapperScan(basePackages = { "com.music125.stock.biz.dal" })
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })

public class StockWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockWebApplication.class, args);
    }

}
