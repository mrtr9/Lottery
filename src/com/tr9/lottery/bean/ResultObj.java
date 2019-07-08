package com.tr9.lottery.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResultObj {
    private String code;
    private String msg;
    private List<Datas> data;
}
