package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasSignRawDataParam {
    private String vaultId;
    /**
     * 签名数据
     */
    @NotNull
    private String rawData = "0x4dac0911bbb5f363e04c425d84a84a98355285fb359ca212701528bf9f4164d4";
    /**
     * 唯一id
     * <p> 用户自己生成的请求唯一id, 用于重试<p/>
     */
    @NotNull

    private String requestId = "413497079388421";
    /**
     * 钱包id
     */
    @NotNull

    private String walletId = "413497079382091";
    /**
     * 地址对应的path
     * <p>eth 示例 m/1/1/60/0 <p/>
     */
    @NotNull

    private String hdPath = "m/1/1/60/0";




}
