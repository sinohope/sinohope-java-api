package com.sinohope.response;

import lombok.Data;

@Data
public class WaasGetWalletBalanceDTO {
    /**
     * 链名称 简称 链标识
     */
    private String chainSymbol;

    /**
     * 币名称 简称 币标识
     */
    private String assetId;
    /**
     * 金额
     * <p>比如1个eth,精度18位, 这里就是 10^18 Wei,   1,000,000,000,000,000,000 <p/>
     */
    private String balance;

    /**
     * 币种精度
     */
    private Integer assetDecimal;

}
