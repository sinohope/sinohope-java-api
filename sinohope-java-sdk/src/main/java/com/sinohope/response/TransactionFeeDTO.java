package com.sinohope.response;

import lombok.Data;

@Data
public class TransactionFeeDTO {
    /**
     *  低档交易费
     */
    private String slowFee;
    /**
     *  中档交易费
     */
    private String averageFee;
    /**
     *  高档交易费
     */
    private String fastFee;

    /**
     *  每个字节的费用
     */
    private String feePerByte;

}