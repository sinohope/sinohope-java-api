package com.sinohope.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CollectStrategyRes {
    private Long vaultId;

    private String toAddress;

    private String assetId;

    private String chainSymbol;

    private BigDecimal minimumCollectionAmount; //最小归集金额

    private BigDecimal minimumReserveAmount; //最小保留金额

    private BigDecimal feeLimit;  //选填，如预估当前交易手续费大于阈值，则跳过本轮归集；

    private int enabled; //默认0关闭，1开启；关闭后，下一轮归集任务将不再检查当前地址余额；

    private String type; //0:token 1:coin

    private Integer autoFueling; //默认0关闭，1开启；关闭后，下一轮归集任务将不再检查当前地址余额；
}
