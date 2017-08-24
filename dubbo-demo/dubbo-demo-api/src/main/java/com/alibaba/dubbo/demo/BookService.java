package com.alibaba.dubbo.demo;

import com.alibaba.dubbo.demo.vo.Book;
import com.alibaba.dubbo.demo.vo.PageList;
import com.alibaba.dubbo.demo.vo.SubList;
import com.alibaba.dubbo.demo.vo.SubMap;

import java.util.List;

/**
 * Created by HuQingmiao on 2017/4/3 0003.
 */
public interface BookService {

    List<Book> findBooks(String title);

    PageList<Book> findAllBooks();

    SubList<Book> findAllBooksHehe();

    SubMap<String, Object> rmap();
}
