package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.SerializeTestService;
import com.alibaba.dubbo.demo.vo.Book;
import com.alibaba.dubbo.demo.vo.MyFjArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huqingmiao on 2017-8-23.
 */
public class SerializeTestImpl implements SerializeTestService {

    @Override
    public JSONObject ttt() {
        String str = "{\"area\":\"440100\",\n" +
                "\"certType\":\"居民身份证\",\n" +
                "\"paymentDetail\":\n" +
                "[{\"bizType\":\"托收汇缴\",\"balance\":\"1400.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"bizType\":\"托收汇缴\",\"balance\":\"1000.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"}],\n" +
                "\"company\":\"广奥依迪电子厂\",\n" +
                "\"premiumBase\":\"2000.00\"}";

        System.out.println("\n>>>>>>>>>>>>>Provider:\n"+str);
        JSONObject obj = JSONObject.parseObject(str);
        return obj;
    }

    @Override
    public MyFjArray ttt2() {

        MyFjArray array = new MyFjArray();

        List<Object> list = new ArrayList<Object>();

        Book book2 = new Book();
        book2.setBookId(5552L);
        book2.setPrice(800.0D);
        book2.setTitle("Unssssssssssssdrr程2");
        book2.setPublishTime(new java.sql.Date(new Date().getTime()));
        list.add(book2);
        list.add(book2);

        array.addAll(list);

        return array;
    }
}
