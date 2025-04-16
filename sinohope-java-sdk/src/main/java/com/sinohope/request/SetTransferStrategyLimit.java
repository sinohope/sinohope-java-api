package com.sinohope.request;

import lombok.Data;

@Data
public class SetTransferStrategyLimit {
    //限制类型:0-所有人累计；1-个人累计；2-每笔交易
    private Integer type;
    //资产计价单位：usdt
    private String chargeUnit;
    //金额限制
    private Long limit24TimeAmount;
}
