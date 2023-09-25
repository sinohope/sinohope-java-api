package com.sinohope.response;

import lombok.Data;

import java.util.List;

@Data
public class WaasTransactionDTO {



    private static final String actionTypeTransfer = "Transfer";
    private static final String actionTypeWeb3Tx = "Web3Tx";
    /**
     * sinoId
     */
    private Long  sinoId;
    private String requestId;
    private Long replacedSinoId;

    /**
     * 网络
     */
    private String chainSymbol;
    private Integer txDirection;
    private Integer state;
    private String note;

    /**
     * 签名交易信息
     */
    private TxInfo transaction;



}
