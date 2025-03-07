package com.sinohope.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CollectionStrategyReq {
    private String vaultId;

    private String toAddress;

    private String assetId;

    private BigDecimal minimumCollectionAmount; //必填，最小归集金额

    private BigDecimal minimumReserveAmount; //选填，最小保留金额

    private BigDecimal feeLimit;  //选填，如预估当前交易手续费大于阈值，则跳过本轮归集；

    private Integer enabled; //默认0关闭，1开启；关闭后

    private Integer autoFueling;   //必填，0-关闭；1-开启


}
