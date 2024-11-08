package com.sinohope.request;

import lombok.Data;

import java.util.List;

@Data
public class WalletTransactionSendWAASParam {


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
     * memo
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

    private String feeRate;

    /**
     * 交易gasPrice，燃料价格，ETH 账号模型适用，单位为 wei
     */
    private String gasPrice;

    /**
     * 交易gasLimit，燃料上限，ETH 账号模型适用
     */
    private String gasLimit;

    /**
     * 备注：用于用户自己需要的一些备注信息
     */
    private String remark="用户交易信息备注";

    /**
     * 金库id
     */
    private String vaultId;
    private String note;
    private String utxoType;

    private List<VinDTO> vins;

    private String tokenId;
}
