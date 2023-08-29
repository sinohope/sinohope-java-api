package com.sinohope.request;

import lombok.Data;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasListAddressesParam {

    private String vaultId;
    /**
     * 当前页码，首页为0,默认0
     */
    private Integer pageIndex = 1;

    /***
     * 每页数据条数（不得小于1,不得大于50）
     */
    private Integer pageSize = 50;
    /**
     * 钱包id
     */
    private String walletId ;
    /**
     * 链名称 简称 链标识
     */
    private String chainSymbol;

}
