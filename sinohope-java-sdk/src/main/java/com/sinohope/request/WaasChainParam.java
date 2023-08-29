package com.sinohope.request;

import lombok.Data;


/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasChainParam {
    /**
     * 链名称 简称 链标识 具有唯一性
     */
    private String chainSymbol ;
    private String vaultId;


}
