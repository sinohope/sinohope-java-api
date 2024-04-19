package com.sinohope.request;

import lombok.Data;

@Data
public class WaasBrc20InscribeTransferByIdParam {
    /**
     * 请求方交易的requestId
     */
    private String requestId;
    private String inscriptionId;
    private String ticker;
    /**
     * 链标识
     */
    private String chainSymbol;
    /**
     * from地址
     */
    private String from;

    private String to;
}
