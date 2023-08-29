package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yanghaiyu
 * @date 2023/07/28
 **/
@Data
@Accessors(chain = true)
public class WaasAddressInfo {
    /**
     * 地址id
     */
    private String id;

    /**
     * 链地址
     */
    private String address;

    /**
     * 地址对应的path
     */
    private String hdPath;

    /**
     * 链地址
     * 地址类型（例：BTC链：Legacy（P2PKH）格式：0，Native SegWit（Bech32）格式：2）
     */
    private Integer encoding;

    /**
     * 公钥
     */
    private String pubkey;
}
