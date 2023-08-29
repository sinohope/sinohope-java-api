package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasListAddedChainsParam {
    private String vaultId;
    /**
     * 钱包id
     */
    @NotNull
    private String walletId = "413497079388421";


}
