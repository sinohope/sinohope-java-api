package com.sinohope.request;

import lombok.Data;

@Data
public class RunesCreateTransferReq{

    /**
     * 请求方交易的requestId
     */
    private String requestId;
    /**
     * 链标识
     */
    private String chainSymbol;
    /**
     * 发起的地址
     */
    private String from;
    private String to;
    private String runeId;
    private String amount;

    /**
     * 手续费 对于 UTXO 类的非EVM兼容链的交易,自设置fee, 如参数为 UTXO 资产转账提供，表示每字节的手续费
     */
    private String fee;
    private String feeRate;


    /**
     * 备注：用于用户自己需要的一些备注信息
     */
    private String remark;

    private String note;
}
