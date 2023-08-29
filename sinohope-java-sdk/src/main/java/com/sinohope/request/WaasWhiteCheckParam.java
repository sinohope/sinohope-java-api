package com.sinohope.request;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
public class WaasWhiteCheckParam {
    /**
     * 校验地址
     */
    @NotNull
    private String address = "0x4dac0911bbb5f363e04c425d84a84a98355285fb359ca212701528bf9f4164d4";


    /**
     * 币名称 简称 币标识 具有唯一性
     */
    @NotNull
    private String assetId = "USDT_ETH";


}
