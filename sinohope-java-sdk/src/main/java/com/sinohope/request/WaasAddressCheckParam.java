package com.sinohope.request;

import lombok.Data;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasAddressCheckParam {
    /**
     * 币种代号 币标识 具有唯一性
     */
    private String assetId;
    /**
     * 地址
     */
    private String address ;

}
