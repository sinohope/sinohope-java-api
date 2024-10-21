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
    private String sinoId;
    private String requestId;
    private String replacedSinoId;

    /**
     * 网络
     */
    private String chainSymbol;
    private Integer txDirection;
    private Integer state;
    private String failReason;
    private String note;

    /**
     * 签名交易信息
     */
    private TxInfo transaction;


    /**
     * brc20Detail
     */
    private Brc20Detail brc20Detail;

    /**
     * brc20Detail
     */
    private List brc20Details;

    private List runeDetails;


}
