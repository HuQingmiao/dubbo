package com.alibaba.dubbo.demo.vo;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by HuQingmiao on 2017/4/3.
 */
public class SubList<E> extends PageList<E> {
    private static final long serialVersionUID = 1L;

    private Book book;

    private int totalCount;

    private String desc;

    public SubList() {
    }


    public SubList(Collection<? extends E> c, int totalCount) {
        super(c, totalCount);
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static void main(String[] args) {

        Class clasz = SubList.class;
        for (; !clasz.getName().startsWith("java."); clasz = clasz.getSuperclass()) {
            Field[] fields = clasz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(">> " + clasz.getSimpleName() + "." + field.getName() + " " + field.getType());
            }
        }
    }
}
