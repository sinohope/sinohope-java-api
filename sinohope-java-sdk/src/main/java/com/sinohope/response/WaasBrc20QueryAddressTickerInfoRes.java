package com.sinohope.response;

import lombok.Data;

import java.util.List;

@Data
public class WaasBrc20QueryAddressTickerInfoRes {

    private String ticker;
    private String overallBalance;
    private String transferableBalance;
    private String availableBalance;
    private String availableBalanceSafe;
    private String availableBalanceUnSafe;
    private String transferableCount;
    private List<TransferableInscription> transferableInscriptions;
    private Integer historyCount;
    private List<HistoryInscription> historyInscriptions;
}
