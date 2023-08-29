package com.sinohope.request;

import lombok.Data;

@Data
public class WalletTransactionCancelWAASParam {

    /**
     * 请求方的requestId
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

    private String gasLimit;
    /**
     * 交易gasPrice，燃料价格，ETH 账号模型适用，单位为 wei
     */
    private String gasPrice;

}
