package com.tr9.lottery.service.impl;

import com.tr9.lottery.bean.Datas;
import com.tr9.lottery.bean.ResultObj;
import com.tr9.lottery.util.HttpUtil;
import javafx.beans.binding.When;
import net.sf.json.JSONObject;
import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.bean.Calc;
import com.tr9.lottery.service.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class ServiceImpl implements Service {
    public List<Bean> list(Integer num) throws Exception {
        HttpUtil httpUtil = new HttpUtil();
        String datastr = httpUtil.getData(num);
        HashMap<String, Class<?>> classMap = new HashMap<String, Class<?>>();
        classMap.put("data",Datas.class);
        JSONObject jsonObject = JSONObject.fromObject(datastr);
        ResultObj resultObj =(ResultObj) JSONObject.toBean(jsonObject, ResultObj.class,classMap);
        List<Datas> datas = resultObj.getData();
        List<Bean> beans = new ArrayList<Bean>();
        for (Datas data:datas){
            Bean bean = new Bean();
            bean.setOpenNumber(data.getOpenNumber());
            String issue = data.getIssue();
            String sbstr = issue.substring(4);
            bean.setIssue(sbstr);
            String openNumber = data.getOpenNumber();
            String[] split = openNumber.split(",");
            bean.setNumOne(split[0]);
            bean.setNumTwo(split[1]);
            bean.setNumThree(split[2]);
            int sum=0;
            for (int i = 0; i < split.length; i++) {
                sum+=Integer.parseInt(split[i]);
            }
            bean.setSumValue(String.valueOf(sum));
            if (sum%2==0){
                bean.setSingleOrDouble("双");
            }else{
                bean.setSingleOrDouble("单");
            }
            if (4<sum&&sum<10){
                bean.setNumSize("小");

            }else{
                bean.setNumSize("大");
            }
            if(split[0] == split[1] && split[1] == split[2]){
                bean.setSimilarities(true);
            }else{
                bean.setSimilarities(false);
            }
            beans.add(bean);
        }
        return beans;
    }

    public List<Bean> list(List<Bean> bea,String start, String end) throws Exception{
        //List<Bean> date = cache.get("date");
       // List<Bean> date = this.list(100);

        List<Bean> beans = new ArrayList<Bean>();
        for (Bean bean:bea){
            String issue = bean.getIssue();
            if (Integer.valueOf(start)>=Integer.valueOf(issue)&&Integer.valueOf(issue)>=Integer.valueOf(end)){
               beans.add(bean);
            }
        }
        return beans;
    }


    public List<Calc> get(List<Bean> beans) {

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
        //计算出每个数出现的次数
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
        //计算每个概率
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
        //根据概率来提取最大的三位，然后进行判断
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

        return lastList;
    }


}
