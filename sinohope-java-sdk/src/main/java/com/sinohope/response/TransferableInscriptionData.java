package com.sinohope.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferableInscriptionData {
    private String op;
    private String tick;
    private String max;
    private String lim;
    private String amt;
    private String decimal;
    private String minted;
}
