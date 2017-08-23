package com.alibaba.dubbo.demo.consumer;


import com.alibaba.dubbo.demo.BookService;
import com.alibaba.dubbo.demo.SerializeTestService;
import com.alibaba.dubbo.demo.vo.Book;
import com.alibaba.dubbo.demo.vo.PageList;
import com.alibaba.dubbo.demo.vo.SubList;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


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
        System.out.println("\n>>>>>>>>>>>>>Consumer:\n"+jsonObject.toJSONString());
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
    }
}
