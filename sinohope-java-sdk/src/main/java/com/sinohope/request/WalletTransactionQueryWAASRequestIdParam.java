package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WalletTransactionQueryWAASRequestIdParam {


    /**
     * 通过requestIds查询获取已确认交易记录列表，requestId以逗号分割，不能为空且不能大于50个
     */
    @NotNull
    private String requestIds;

}
