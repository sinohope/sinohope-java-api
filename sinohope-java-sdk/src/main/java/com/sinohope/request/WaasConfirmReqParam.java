package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WaasConfirmReqParam {

    /**
     * 请求的唯一id,多次调用不便
     */
    @NotNull
    private String requestId = "413497079388421";
    /**
     * 回调请求的详细信息；每种类型的回调请求对应于不同的requestDetail结构；格式为序列化的 JSON 字符串
     */
    @NotNull
    private String requestDetail ="{\n" +
            "  \"walletId\": \"52321312\",\n" +
            "  \"requestId\": \"2132134\",\n" +
            "  \"vaultId\": \"123\",\n" +
            "  \"chainSymbol\": \"ETH\",\n" +
            "  \"assetId\": \"USDC_ETH\",\n" +
            "  \"from\": \"0xc429aeda8bf786cf092224dddadbc0813f9f230b\",\n" +
            "  \"to\": \"0x546A62c54F50D57D30478C8C275360f20239A23E\",\n" +
            "  \"toTag\": \"32143\",\n" +
            "  \"amount\": \"1200000000000000\",\n" +
            "  \"fee\": \"1000000\",\n" +
            "  \"gasPrice\": \"13250000\",\n" +
            "  \"gasLimit\": \"21000\"\n" +
            "}";;
    /**
     * 与回调请求相关的其他信息；每种类型的回调请求对应于不同的extra_info结构；格式为序列化 JSON 字符串
     */
    private String extraInfo;


}
