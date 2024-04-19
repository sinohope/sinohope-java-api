package com.sinohope.request;

import lombok.Data;

@Data
public class WaasBrc20QueryAddressBalanceReq {

    /**
     * 链标识
     */
    private String chainSymbol;
    private String address;
}
