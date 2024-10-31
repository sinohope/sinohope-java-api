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
    /**
     * 查询类型：0-普通代币；1-nft；不传默认为0
     */
    private Integer queryType;


}
