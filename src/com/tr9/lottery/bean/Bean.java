package com.tr9.lottery.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 13:30
 */
@Data
public class Bean {
    //期号
    private String issue;
    //开奖号码
    private String openNumber;
    //第一位
    private String numOne;
    //第二位
    private String numTwo;
    //第三位
    private String numThree;
    //和值
    private String sumValue;
    //大小
    private String numSize;
    //单双
    private String singleOrDouble;
    //三同
    private boolean similarities;
}
