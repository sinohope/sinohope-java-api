package com.sinohope.request;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
public class WaasWalletAddCoinParam {
    /**
     * 钱包id
     */
    private String walletId;
    /**
     * 币种代号
     */
    private String coin;
    /**
     * 币种缩写（非唯一，可能变化，仅供参考)
     */
    private String displayCode;
    /**
     * 	币种名称全称（非唯一，可能变化，仅供参考）
     */
    private String description;

}
