package com.sinohope.request;

import lombok.Data;

@Data
public class WaasBrc20QueryAddressTickerInfoReq {

    /**
     * 链标识
     */
    private String chainSymbol;
    private String address;
    private String ticker;
}
