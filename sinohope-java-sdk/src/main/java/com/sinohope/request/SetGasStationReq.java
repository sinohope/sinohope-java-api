package com.sinohope.request;

import lombok.Data;

@Data
public class SetGasStationReq {
    private String chainSymbol;
    private String address;   //必填，加油站地址
}
