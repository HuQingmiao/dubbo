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
                "\"lastPaymentMonth\":\"2017-07-20\",\n" +
                "\"oprState\":\"0\",\n" +
                "\"accStatus\":\"正常\",\n" +
                "\"certNo\":\"440182198511300629\",\n" +
                "\"companyPremiumPer\":\"5\",\n" +
                "\"personPremiumPer\":\"5\",\n" +
                "\"yearPayment\":\"200.00\",\n" +
                "\"balance\":\"1605.68\",\n" +
                "\"fundNo\":\"44018219851130062900\",\n" +
                "\"paymentDetail\":\n" +
                "[{\"amount\":\"200.00\",\"billDat\":\"2017-06-14\",\"bizType\":\"托收汇缴\",\"balance\":\"1400.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-02-17\",\"bizType\":\"托收汇缴\",\"balance\":\"600.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"5.68\",\"billDat\":\"2017-06-30\",\"bizType\":\"年度结息\",\"balance\":\"1405.68\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-02-16\",\"bizType\":\"托收汇缴\",\"balance\":\"400.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-05-19\",\"bizType\":\"托收汇缴\",\"balance\":\"1200.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-03-13\",\"bizType\":\"托收汇缴\",\"balance\":\"800.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-07-20\",\"bizType\":\"托收汇缴\",\"balance\":\"1605.68\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"},\n" +
                "{\"amount\":\"200.00\",\"billDat\":\"2017-04-28\",\"bizType\":\"托收汇缴\",\"balance\":\"1000.00\",\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\"}],\n" +
                "\"areaName\":\"广州市\",\n" +
                "\"requestId\":\"FTC_DEVFTC_DEV2017072500000002\",\n" +
                "\"name\":\"江凤敏\",\n" +
                "\"company\":\"广州市花都区奥依迪电子厂\",\n" +
                "\"state\":\"0\",\n" +
                "\"premiumBase\":\"2000.00\"}";

        System.out.println("\n>>>>>>>>>>>>>Provider:\n"+str);
        JSONObject obj = JSONObject.parseObject(str);
        return obj;
    }
}
