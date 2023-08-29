package com.sinohope.response;

import lombok.Data;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasChainVO {
    /**
     *  链全名
     */
    private String chainName;
    /**
     * 链名称 简称 链标识 具有唯一性
     */
    private String chainSymbol;


}
