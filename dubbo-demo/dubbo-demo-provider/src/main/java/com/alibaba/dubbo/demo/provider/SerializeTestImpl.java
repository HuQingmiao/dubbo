package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.SerializeTestService;
import com.alibaba.fastjson.JSONObject;

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
}
