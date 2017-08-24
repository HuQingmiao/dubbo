package com.alibaba.dubbo.demo.provider;


import com.alibaba.dubbo.demo.BookService;
import com.alibaba.dubbo.demo.vo.Book;
import com.alibaba.dubbo.demo.vo.PageList;
import com.alibaba.dubbo.demo.vo.SubList;
import com.alibaba.dubbo.demo.vo.SubMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HuQingmiao on 2015/4/7.
 */
public class BookServiceImpl implements BookService {

    public List<Book> findBooks(String title) {
        Book book1 = new Book();
        book1.setBookId(111L);
        book1.setPrice(32.0D);
        book1.setTitle("Unix网络编程1");
        book1.setPublishTime(new java.sql.Date(new Date().getTime()));

        Book book2 = new Book();
        book2.setBookId(112L);
        book2.setPrice(80.0D);
        book2.setTitle("Unix网络编程2");
        book2.setPublishTime(new java.sql.Date(new Date().getTime()));

        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        return books;
    }

    public PageList<Book> findAllBooks() {
        List<Book> books = this.findBooks("网络编程");

        ArrayList<Book> aList1 = new ArrayList();
        Book b = new Book();
        b.setBookId(555L);
        b.setPrice(220.0D);
        b.setTitle("slist1 BOOK　1");
        aList1.add(b);
        Book b2 = new Book();
        b2.setBookId(55445L);
        b2.setPrice(234420.0D);
        b2.setTitle("slist1 BOOK　2");
        aList1.add(b2);

        ArrayList<Book> aList2 = new ArrayList();
        Book b3 = new Book();
        b3.setBookId(33333333333333L);
        b3.setPrice(23433420.0D);
        b3.setTitle("slist2 BOOK");
        aList2.add(b3);

        books.get(0).setaList(aList1);
        books.get(1).setaList(aList2);

        return new PageList<Book>(books, 8);
    }

    public SubList<Book> findAllBooksHehe() {
        List<Book> books = this.findBooks("网络编程");
        SubList<Book> sList = new SubList<Book>(books, 5);
        sList.setTotalCount(8);
        sList.setDesc("看仔细啦");

        Book book2 = new Book();
        book2.setBookId(5552L);
        book2.setPrice(800.0D);
        book2.setTitle("Unssssssssssssdrr程2");
        book2.setPublishTime(new java.sql.Date(new Date().getTime()));
        sList.setBook(book2);
        return sList;
    }

    public  SubMap<String, Object> rmap(){
        SubMap map = new SubMap();
        map.put("asdf", new String[]{"a","b"});
        map.setStr("我不生知道");
        return map;
    }
}
