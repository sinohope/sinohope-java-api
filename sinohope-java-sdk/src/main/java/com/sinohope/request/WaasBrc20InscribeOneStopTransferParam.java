package com.sinohope.request;

import lombok.Data;

@Data
public class WaasBrc20InscribeOneStopTransferParam {
    private String requestId;

    /**
     * 链标识
     */
    private String chainSymbol;

    private String amount;

    private String from;
    private String fromTag;

    private String to;
    private String toTag;
    private String note;
    private String ticker;
    private String fee;
    private String feeRate;
}
