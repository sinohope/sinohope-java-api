package com.sinohope.response;

import lombok.Data;


@Data
public class WaasBrc20QueryAddressBalanceRes {

    private String address;
    private Long satoshi;

    private Integer pendingSatoshi;

    private Integer utxoCount;
    private Long btcSatoshi;
    private Long btcPendingSatoshi;
    private Integer btcUtxoCount;
    private Long inscriptionSatoshi;
    private Integer inscriptionPendingSatoshi;

    private Integer inscriptionUtxoCount;
}
