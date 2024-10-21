package com.sinohope.request;

import lombok.Data;

@Data
public class RunesBalanceReq {

    /**
     * 链标识
     */
    private String chainSymbol;
    private String address;
    private String runeId;
}
