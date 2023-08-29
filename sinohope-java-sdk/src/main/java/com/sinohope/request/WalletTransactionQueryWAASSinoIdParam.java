package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WalletTransactionQueryWAASSinoIdParam {



    /**
     * 通过sinoId查询获取已确认交易记录列表，sinoid是sinohope唯一标识交易id，以逗号分割，不能为空且不能大于50个
     */
    @NotNull
    private String sinoIds;

}
