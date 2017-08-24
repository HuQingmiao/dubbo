package com.alibaba.dubbo.demo.consumer;


import com.alibaba.dubbo.demo.BookService;
import com.alibaba.dubbo.demo.SerializeTestService;
import com.alibaba.dubbo.demo.vo.*;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


/**
 * Created by HuQingmiao on 2015/4/7.
 */
public class Client {
    private static Logger log = LoggerFactory.getLogger(Client.class);

    private static ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"dubbo-consumer.xml"});


    public void callFindBooks() {
        BookService bookService = (BookService) context.getBean("bookService");
        List<Book> bookList = bookService.findBooks("随便啦");
        for (Book book : bookList) {
            log.info(">> " + book.toString());
        }
    }

    public void callFindAllBooks() {
        BookService bookService = (BookService) context.getBean("bookService");
        PageList<Book> pList = bookService.findAllBooks();
        log.info(">> tcnt: " + pList.getTotalCount());
        log.info(">> size: " + pList.size());
        for (Book book : pList) {
            log.info(">> " + book.toString());
        }

        log.info(">> abList: " + pList.getAbList().size());
        log.info(">> abList: " + pList.getAbList().get(0));

        Map<String, Long[]> map = pList.getAbMap();
        for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Long[] ls = map.get(key);
            log.info("\n");
            for (Long l : ls) {
                log.info(">> "+l);
            }
        }
    }

    public void callFindAllBooksHehe() {
        BookService bookService = (BookService) context.getBean("bookService");
        SubList<Book> sList = bookService.findAllBooksHehe();
        log.info(">> tcnt: " + sList.getTotalCount());
        log.info(">> size: " + sList.size());
        log.info(">> desc: " + sList.getDesc());
        log.info(">> book: " + sList.getBook());
        for (Book book : sList) {
            log.info(">> " + book.toString());
        }
    }

    public void catTtt() {
        SerializeTestService serializeTestService = (SerializeTestService) context.getBean("serializeTestService");
        JSONObject jsonObject = serializeTestService.ttt();
        System.out.println("\n>>>>>>>>>>>>>Consumer:\n" + jsonObject.toJSONString());
    }

    public void callTtt2() {
        SerializeTestService serializeTestService = (SerializeTestService) context.getBean("serializeTestService");
        MyFjArray array = serializeTestService.ttt2();


        for (Object obj : array) {
            log.info(">> " + obj.toString());
        }
    }


    public void rmap() {
        BookService bookService = (BookService) context.getBean("bookService");
        SubMap map = bookService.rmap();

        for (Iterator it = map.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            System.out.println(key + ": " + map.get(key));
            System.out.println("str: " + map.getStr());
        }
    }


    public static void main(String[] args) {
        log.info("-----------------------------------");

        Client client = new Client();
//
//        log.info(" --------- callFindBooks:  ");
//        client.callFindBooks();
//
//        log.info(" --------- callFindAllBooks:  ");
//        client.callFindAllBooks();
//
//        log.info(" --------- callFindAllBooksHehe:  ");
//        client.callFindAllBooksHehe();

        log.info(" --------- callTtt:  ");
        client.catTtt();

//        client.callTtt2();


    }
}
