package com.sinohope.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class TransferHistoryWAASDTO extends BaseWaasParam {



    /**
     * sinoId
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long sinoId;

    /**
     * 资产Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private String assetId;

    /**
     * 资产名称
     */
    private String assetName;

    /**
     * 链简称
     */
    private String chainSymbol;

    /**
     * 链名称
     */
    private String chainName;

    /**
     * 交易方向类型 1充值 2提现
     */
    private String txDirection;

    /**
     * 交易类型 eth交易 1：Eip2930 2：Eip1559
     */
    private String txType;

    /**
     * 精度
     */
    private int decimal;
    /**
     * 链对应的主币的精度
     */
    private Integer coinDecimals ;

    private TransactionWAAS transaction;



    /**
     * 更新时间
     * 格式 "2022-02-02 00:00:00"
     */
    private String updateTime;

}
