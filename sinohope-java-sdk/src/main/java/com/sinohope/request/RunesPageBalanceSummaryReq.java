package com.sinohope.request;

import lombok.Data;

@Data
public class RunesPageBalanceSummaryReq {

    /**
     * 链标识
     */
    private String chainSymbol;
    private Long start;
    private Long limit;
    private String address;
}
