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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {
    public static final Map<String,List> cache=new HashMap<String,List>();
    public List<Bean> list(Integer num) throws Exception {
        HttpUtil httpUtil = new HttpUtil();
        String datastr = httpUtil.getData(num);
        HashMap<String, Class<?>> classMap = new HashMap<String, Class<?>>();
        classMap.put("data",Datas.class);
        JSONObject jsonObject = JSONObject.fromObject(datastr);
        ResultObj resultObj =(ResultObj) JSONObject.toBean(jsonObject, ResultObj.class,classMap);
        List<Datas> datas = resultObj.getData();
        //  System.out.println(datas.toString());
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
        cache.put("date",beans);
        return beans;
    }

    public List<Bean> list(String start, String end) throws  Exception{
        //List<Bean> date = cache.get("date");
        List<Bean> date = this.list(100);
        System.out.println("111===="+date.toString());
        List<Bean> beans = new ArrayList<Bean>();
        for (Bean bean:date){
            String issue = bean.getIssue();
            if (Integer.valueOf(start)>=Integer.valueOf(issue)&&Integer.valueOf(issue)>=Integer.valueOf(end)){
               beans.add(bean);
            }
        }
        return beans;
    }


    public Calc get(List<Bean> beans) {
        return null;
    }
}
