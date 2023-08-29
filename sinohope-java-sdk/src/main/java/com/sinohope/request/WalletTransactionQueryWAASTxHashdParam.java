package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WalletTransactionQueryWAASTxHashdParam {


    /**
     * 通过交易txHash，查询获取已确认交易记录列表
     */
    @NotNull
    private String txHash;

    /**
     * 链标识
     */
    @NotNull
    private String chainSymbol;

}
