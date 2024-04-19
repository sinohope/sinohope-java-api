package com.sinohope.response;

import lombok.Data;

@Data
public class HistoryInscription {
    private TransferableInscriptionData data;
    private Long inscriptionNumber;
    private String inscriptionId;
    private Integer satoshi;
    private Integer confirmations;
}
