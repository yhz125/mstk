/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.music125.stock;

import com.geccocrawler.gecco.GeccoEngine;

/**
 * TODO
 *
 * @author weiyi
 * @version V1.0
 * @since 2019-08-27 19:23
 */
public class test {
    public static void main(String[] args) {
        GeccoEngine.create()
            //工程的包路径
            .classpath("com.music125.stock.parse.eastmoney")
            //开始抓取的页面地址
            .start("http://quote.eastmoney.com/stock_list.html")
            //开启几个爬虫线程
            .thread(10)
            //单个爬虫每次抓取完一个请求后的间隔时间
            .interval(5)
            //使用pc端userAgent
            .mobile(false)
            //开始运行
            .run();
    }
}
