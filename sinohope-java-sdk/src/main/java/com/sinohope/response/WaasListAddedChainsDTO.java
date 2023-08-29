package com.sinohope.response;

import lombok.Data;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasListAddedChainsDTO {
    /**
     * 链名称 简称 链标识
     */
    private String chainSymbol;
    /**
     * 地址
     */
    private WaasAddressInfo firstAddressInfo;
}
