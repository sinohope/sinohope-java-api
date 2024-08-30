package com.sinohope.request;

import lombok.Data;

@Data
public class WaasPageUtxoReq {

    /**
     * 钱包id
     */
    private String walletId;

    /**
     * 链标识
     */
    private String chainSymbol;
    /**
     * 资产id
     */
    private String assetId;

    /**
     * from 地址
     */
    private String from;
    //默认1
    private Integer page;
    //最大100
    private Integer pageSize;
    //1-ace 2-desc
    private Integer sort;
    //amount || voutId
    private String sortType;

}
