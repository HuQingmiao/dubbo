package com.alibaba.dubbo.demo.vo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by HuQingmiao on 2017/4/3.
 */
public class PageList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1412759446332294208L;

    private int totalCount;

    public PageList() {
        super();
    }

    public PageList(Collection<? extends E> c, int totalCount) {
        super(c);
        this.totalCount = totalCount;
    }

    public PageList(Collection<? extends E> c) {
        super(c);
        this.totalCount = c.size();
    }

    public int getTotalCount() {
        return totalCount;
    }
}