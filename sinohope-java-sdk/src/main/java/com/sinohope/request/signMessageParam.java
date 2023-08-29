package com.sinohope.request;

import lombok.Data;

@Data
public class signMessageParam {

    /**
     * 请求方交易的requestId
     */
    private String requestId;

    /**
     * 链
     */
    private String chainSymbol;

    /**
     * 资产id
     */
    private String assetId;

    /**
     * bip32、bip44的推导路径
     */
    private String hdPath;

    /**
     *  支持签名算法: （personal_sign、signTypedData、eth_signTypedData_v3、eth_signTypedData_v4）
     */
    private String signAlgorithm;

    /**
     * 待签名的字符串信息
     */
    private String message;
}
