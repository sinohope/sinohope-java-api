package com.sinohope.response;

import lombok.Data;

@Data
public class FeeDTO {
    private TransactionFeeDTO transactionFee;
    private GasFeeDTO gasFee;

}