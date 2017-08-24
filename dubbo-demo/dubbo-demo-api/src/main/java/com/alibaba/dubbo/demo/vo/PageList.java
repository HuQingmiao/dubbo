package com.alibaba.dubbo.demo.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by HuQingmiao on 2017/4/3.
 */
public class PageList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1412759446332294208L;

    private int totalCount;

    private List<String> abList;

    private Map<String, Long[]> abMap;

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

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<String> getAbList() {
        return abList;
    }

    public void setAbList(List<String> abList) {
        this.abList = abList;
    }

    public Map<String, Long[]> getAbMap() {
        return abMap;
    }

    public void setAbMap(Map<String, Long[]> abMap) {
        this.abMap = abMap;
    }
}