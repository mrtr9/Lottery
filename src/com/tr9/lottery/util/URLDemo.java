package com.tr9.lottery.util;

import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.bean.Datas;
import com.tr9.lottery.bean.ResultObj;
import com.tr9.lottery.service.impl.ServiceImpl;
import net.sf.json.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class URLDemo {
    public static void main(String[] args) throws Exception {
        ServiceImpl service = new ServiceImpl();
        /*List<Bean> list = service.list(10);
        System.out.println(list.toString());*/
//        List<Bean> beans = service.list("07071336", "07071328");
//        System.out.println(beans.toString());
    }
}
