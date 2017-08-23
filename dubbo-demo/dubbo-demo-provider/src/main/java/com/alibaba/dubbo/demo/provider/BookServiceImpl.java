package com.alibaba.dubbo.demo.provider;


import com.alibaba.dubbo.demo.BookService;
import com.alibaba.dubbo.demo.vo.Book;
import com.alibaba.dubbo.demo.vo.PageList;
import com.alibaba.dubbo.demo.vo.SubList;

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
        PageList<Book> pList = new PageList<Book>(books, 5);

        for (Book book : pList) {
            ArrayList<Book> aList = new ArrayList();
            Book b = new Book();
            b.setBookId(555L);
            b.setPrice(220.0D);
            b.setTitle("asdfasr不知道2");
            aList.add(b);

            Book b3 = new Book();
            b3.setBookId(55445L);
            b3.setPrice(234420.0D);
            b3.setTitle("safasf");
            aList.add(b3);

            book.setaList(aList);
        }

        return pList;
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
}
