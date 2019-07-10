package com.tr9.lottery.util;

import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.bean.Calc;
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
import java.text.DecimalFormat;
import java.util.*;

public class URLDemo {
    public static void main(String[] args) throws Exception {

        ServiceImpl service = new ServiceImpl();
        List<Bean> listsd = service.list(10);
        System.out.println(listsd.toString());
        List<Bean> beans = service.list(listsd,"07100822", "07100800");
        int beanSize = beans.size();
        List<String> list = new ArrayList<String>();
        for (Bean bean:beans){
            String sumValue = bean.getSumValue();
            list.add(sumValue);
        }
        String liststr=list.toString();
        String substring = liststr.substring(1, liststr.length() - 1);
        System.out.println(substring);
        String[] split = substring.split(",");
        Map<String,Integer> map = new HashMap<String, Integer>();
        for (String ch : split) {
            if (map.containsKey(ch)) {
                Integer old = map.get(ch);
                map.put(ch, old + 1);
            } else {
                map.put(ch,1);
            }
        }
        String mapstr=map.toString();
        String mapsb = mapstr.substring(1, mapstr.length() - 1);
        String[] mapsp = mapsb.split(",");
        Map<String, String> hashMap = new TreeMap<String, String>();
        for (String str:mapsp){
            String[] splits = str.split("=");
            String num = splits[0];
            String frequency = splits[1];
            Integer integer = Integer.valueOf(frequency);
            double dou = integer * 1.0 / beanSize;
            DecimalFormat df = new DecimalFormat("#0.00");
            String str1 = df.format(dou);
            hashMap.put(num,str1);
        }

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> datelist = new ArrayList<Map.Entry<String,String>>(hashMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(datelist,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        List<Calc> lastList = new ArrayList<Calc>();
        for (int k=datelist.size()-3;k<datelist.size();k++){
            Calc calc = new Calc();
            Map.Entry<String, String> maps = datelist.get(k);
            String key = maps.getKey();
            String trim = key.trim();
            calc.setSumNum(trim);
            String value = maps.getValue();
            Double probability = Double.valueOf(value);
            calc.setProbability(probability);
            Integer value1 = Integer.valueOf(trim);
            if (value1%2==0){
                calc.setSingleOrDouble("双");
            }else{
                calc.setSingleOrDouble("单");
            }
            if (4<value1&&value1<10){
                calc.setSize("小");

            }else{
                calc.setSize("大");
            }

            lastList.add(calc);
        }

        System.out.println(lastList.toString());
    }

        //System.out.println(list.toString());

}
