package com.sinohope.response;

import lombok.Data;

@Data
public class TransferableInscription {

    private TransferableInscriptionData data;

    private String inscriptionId;

    private String satoshi;
    private Long confirmations;
}
