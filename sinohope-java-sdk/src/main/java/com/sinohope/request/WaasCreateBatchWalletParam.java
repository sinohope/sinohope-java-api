package com.sinohope.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
@ToString
public class WaasCreateBatchWalletParam {
    /**
     * 创建多少个 默认值为 1
     */
    private Integer count =1;
    private String vaultId;
    /**
     * 钱包信息
     * 如果不为空 count值必须 walletInfos的数量一致
     */
    private List<WaasCreateWalletInfo> walletInfos;
    private String requestId;

}
