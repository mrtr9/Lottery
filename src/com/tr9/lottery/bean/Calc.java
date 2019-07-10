package com.tr9.lottery.bean;

import lombok.Data;

/**
 * Model:
 * Author:Tr9(韩峰)
 * Description:
 * Time: 2019/7/7 13:32
 */
@Data
public class Calc {
        //和值
        private String sumNum;
        //大小
        private String size;
        //单双
        private String singleOrDouble;
        //概率
        private Double probability;
}
