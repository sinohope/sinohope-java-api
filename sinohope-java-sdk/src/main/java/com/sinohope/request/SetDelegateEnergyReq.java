package com.sinohope.request;

import lombok.Data;

@Data
public class SetDelegateEnergyReq {
    private String chainSymbol;
    private String settlementAddress;
    private Integer isEnabled;
}
