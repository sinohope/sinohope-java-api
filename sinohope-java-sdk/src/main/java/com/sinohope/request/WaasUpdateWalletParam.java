package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasUpdateWalletParam {
    /**
     * 钱包id
     * <p> 当指定了以后就是根据钱包开关,否则就是金库级别 <p/>
     */
    @NotNull
    private String  walletId = "413497079388421";

    /**
     * 高级功能开关 (关：0，开：1)
     * <p> 开了以后支持的功能: 根据指定的路径创建地址 ,原始数据签名 <p/>
     */
    @NotNull
    private Integer advancedEnabled = 1;


}
