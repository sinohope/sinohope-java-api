package com.sinohope.request;

import lombok.Data;

@Data
public class WalletTransactionSpeedupWAASParam {

    /**
     * 请求方交易的requestId
     */
    private String requestId;
    /**
     * 交易gasLimit，燃料上限，ETH 账号模型适用
     */
    private String gasLimit;
    /**
     * 交易gasPrice，燃料价格，ETH 账号模型适用，单位为 wei
     */
    private String gasPrice;
    /**
     * 手续费 对于 UTXO 类的非EVM兼容链的交易,自设置fee, 如参数为 UTXO 资产转账提供，表示每字节的手续费
     */
    private String fee;

//    /**
//     * 加速交易类型 0：普通交易，1：接口加速 1559
//     */
//    @NotNull
//    private String speedupType="0";

    /**
     * 链标识
     */
    private String chainSymbol;
    /**
     * 资产id
     */
    private String assetId;

}
