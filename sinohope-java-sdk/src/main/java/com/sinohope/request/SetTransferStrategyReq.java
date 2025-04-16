package com.sinohope.request;

import lombok.Data;

import java.util.List;

@Data
public class SetTransferStrategyReq {
    //指定地址，逗号分割
    private String fromAddress;
    //指定token
    private String assetId;
    //指定to地址，逗号分割
    private String toAddress;
    //交易限制规则
    private List<SetTransferStrategyLimit> limits;
    //命中结果：0-去审批交易（如果配置命中结果为审批交易，需要启动交易审批）；1-禁止交易发起
    private Integer hitResult;

    private Long vaultId;
    //状态：0-关闭；1-开启
    private Integer state;

}
