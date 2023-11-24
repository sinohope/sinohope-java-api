package com.sinohope.response;

import lombok.Data;

@Data
public class GasFeeDTO {
    private GasInfoDTO slow;
    private GasInfoDTO average;
    private GasInfoDTO fast;

}