package com.sinohope.request;

import lombok.Data;

@Data
public class WalletTransactionSendDataWAASParam {


    /**
     * 钱包id
     */
    private String walletId;

    /**
     * 请求方交易的requestId
     */
    private String requestId;

    /**
     * 链标识
     */
    private String chainSymbol;

    /**
     * 资产id
     */
    private String assetId;

    /**
     * from 地址
     */
    private String from;

    /**
     * to地址
     */
    private String to;

    /**
     * 交易的memo
     */
    private String toTag;

    /**
     * 金额
     */
    private String amount;

    /**
     * 手续费 对于 UTXO 类的非EVM兼容链的交易,自设置fee, 如参数为 UTXO 资产转账提供，表示每字节的手续费
     */
    private String fee;

    /**
     * gasprice
     */
    private String gasPrice;

    /**
     * gaslimit
     */
    private String gasLimit;


    /**
     * 备注：用于用户自己需要的一些备注信息
     */
    private String remark="用户交易信息备注";

    /**
     * 以太坊交易data
     */

    private String inputData;
    /**
     * 金库id
     */
    private String vaultId;
    private String note;
}
