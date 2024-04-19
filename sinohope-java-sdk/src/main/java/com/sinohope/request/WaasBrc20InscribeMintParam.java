package com.sinohope.request;

import lombok.Data;

@Data
public class WaasBrc20InscribeMintParam {

    /**
     * 请求方交易的requestId
     */
    private String requestId;
    private String ticker;
    private String from;
    private String amount;
    /**
     * 链标识
     */
    private String chainSymbol;

    /**
     * memo
     */
    private String toTag;

    /**
     * 手续费 对于 UTXO 类的非EVM兼容链的交易,自设置fee, 如参数为 UTXO 资产转账提供，表示每字节的手续费
     */
    private String fee;

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
    private String remark;

    /**
     * fromTag
     */
    private String fromTag;

    private String note;
}
