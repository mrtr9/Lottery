package com.tr9.lottery.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Datas {
    private String lotteryCode;
    private String issue;
    private String openNumber;
    private String openTime;
    private String open;
    private String createdTime;
}
