package com.tr9.lottery.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 13:39
 */
public class HttpUtil {
        public String getData(Integer num) throws IOException {
            //1、创建httpClient
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://m.80558a.com/v1/lottery/openResult?lotteryCode=1407&dataNum="+num+"&");
            CloseableHttpResponse response = client.execute(httpGet);

            //5、获取实体
            HttpEntity entity = response.getEntity();
            //将实体装成字符串
            String data = EntityUtils.toString(entity);
            System.out.println(data);

            response.close();

            return data;
        }
}
