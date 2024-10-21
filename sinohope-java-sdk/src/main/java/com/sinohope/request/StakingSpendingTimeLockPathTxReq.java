package com.sinohope.request;

import lombok.Data;

@Data
public class StakingSpendingTimeLockPathTxReq {

    /**
     * 请求方交易的requestId
     */
    private String requestId;
    /**
     * 待提取的交易sinoId
     */
    private String oriSinoId;
    private String oriRequestId;
    private String fee;
    private String feeRate;

    /**
     * 备注：用于用户自己需要的一些备注信息
     */
    private String remark;

    private String note;
}
