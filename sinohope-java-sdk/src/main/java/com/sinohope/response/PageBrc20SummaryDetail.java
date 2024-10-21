package com.sinohope.response;

import lombok.Data;

@Data
public class PageBrc20SummaryDetail {
    private String ticker;
    private String overallBalance;
    private String transferableBalance;
    private String availableBalance;
    private String availableBalanceSafe;
    private String availableBalanceUnSafe;
    private Integer decimal;
}
