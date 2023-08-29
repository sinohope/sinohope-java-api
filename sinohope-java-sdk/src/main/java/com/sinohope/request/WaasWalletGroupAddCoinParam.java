package com.sinohope.request;

import java.util.List;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
public class WaasWalletGroupAddCoinParam {
    /**
     * 钱包id
     */
    private String walletId;

    /**
     * 添加币种信息
     */
    private List<WaasWalletAddCoinParam> coins;

}
