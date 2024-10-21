package com.sinohope.response;

import lombok.Data;

import java.util.List;

@Data
public class WaasBrc20QueryInscribeTransfersRes {

    private Long height;
    private Long total;
    private Long start;
    private List<TransferableInscription> detail;
}
