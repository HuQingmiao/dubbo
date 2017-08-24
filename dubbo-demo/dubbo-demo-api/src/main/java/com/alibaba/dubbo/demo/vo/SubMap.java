package com.alibaba.dubbo.demo.vo;

import java.util.HashMap;

/**
 * Created by huqingmiao on 2017-8-24.
 */
public class SubMap<K,V> extends HashMap<K,V> {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
