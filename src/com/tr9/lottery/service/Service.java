package com.tr9.lottery.service;

import com.tr9.lottery.bean.Bean;
import com.tr9.lottery.bean.Calc;

import java.util.List;

/**
 * 业务类接口
 */
public interface Service {

    /**
     * 根据条数得到结果
     * @param num 具体多少条数
     * @return List<Bean>
     */
    public List<Bean> list(Integer num) throws Exception;

    /**
     * 通过开始期号跟结束期号获取结果
     * @param start 开始期号
     * @param end 结束期号
     * @return List<Bean>
     */
    public List<Bean> list(String start ,String end) throws Exception;
    /**
     * 根据传入的bean获取计算结果
     * @param beans List集合的Bean对象
     * @return Calc
     */
    public Calc get(List<Bean> beans);

}
