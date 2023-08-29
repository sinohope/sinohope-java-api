package com.sinohope.request;

import lombok.Data;

@Data
public class WalletTransactionQueryWAASParam {

    /**
     * 当前页码，首页为0,默认0
     */
    private Integer pageIndex=1 ;

    /***
     * 每页数据条数（不得小于1,不得大于50）
     */
    private Integer pageSize;
    /**
     * 链地址
     */
//    @NotNull
    private String address;
    /**
     * sinoId生成的交易id
     */
    private String sinoIds;
    /**
     * 请求方交易的requestId
     */

    private String requestIds;
    /**
     * 交易hash
     */
    private String txHash;
    /**
     * 链标识
     */
//    @NotNull
    private String chainSymbol;
    /**
     * 资产id
     */
    private String assetId;

    /**
     * 根据更新时间查询,开始时间 传了开始时间,开始结束也得带上
     * 格式 "2022-02-02 00:00:00"
     */
    private String startUpdateTime;

    /**
     * 根据更新时间查询,结束时间  传了结束时间,开始时间也得带上
     * 格式 "2022-02-02 00:00:00"
     */
    private String endUpdateTime;
}
