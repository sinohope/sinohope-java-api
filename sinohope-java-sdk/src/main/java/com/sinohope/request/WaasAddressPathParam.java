package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
public class WaasAddressPathParam {
    /**
     * 用于区分同一个钱包的同一个cointype 下的不同地址
     */
    @NotNull
    private Integer index = 1;
    /**
     * 算法类型(0: "ECDSA:secp256k1", 1: "EdDSA:ed25519")
     *
     */
    @NotNull
    private Integer algorithmType = 1;
    /**
     * 参考slip-44 https://github.com/satoshilabs/slips/blob/master/slip-0044.md 中定义的coin type常量，使用none-hardened 的版本。根据业界常规做法，对于所有 eth-like 公链，可公钥以太坊的 coin type 60
     */
    @NotNull
    private Integer coinType = 10;
    /**
     * 钱包id
     */
    @NotNull
    private String walletId = "413497079388421";
    private String vaultId;

}
