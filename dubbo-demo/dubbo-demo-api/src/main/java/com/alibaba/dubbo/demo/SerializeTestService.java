package com.alibaba.dubbo.demo;


import com.alibaba.dubbo.demo.vo.MyFjArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by HuQingmiao on 2015/4/7.
 */
public interface SerializeTestService {
    JSONObject ttt();


    MyFjArray ttt2();
}

