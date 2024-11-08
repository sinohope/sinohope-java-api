package com.sinohope.request;

import lombok.Data;

@Data
public class TransactionFeeParam {
    private String operationType;
    private String from;
    private String to;
    private String assetId;
    private String chainSymbol;
    private String amount;
    private String inputData;
    private String tokenId;
}
