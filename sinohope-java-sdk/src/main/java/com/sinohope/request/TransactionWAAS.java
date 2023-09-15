package com.sinohope.request;

import com.sinohope.response.WaasTransactionDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionWAAS {


    /**
     * 交易hash
     */
    private String txHash;

    /**
     * from地址
     */
    private String from;
    /**
     * from地址tag
     */
    private String fromTag;
    /**
     * to地址
     */
    private String to;
    /**
     * to地址tag
     */
    private String toTag;

    /**
     * 金额：最小精度的整数值 例如：1230000000000000000
     */
    private String amount;

    /**
     * 手续费资产
     */
    private String feeAsset;
    /**
     * 手续费Price
     */
    private String feePrice;
    /**
     * 手续费Step
     */
    private String feeStep;

    /**
     * 交易状态 21-交易已签名待上链 2-交易上链中 4-广播失败 5-交易上链失败 6-广播网络超时 10-交易上链成功 11-交易上链回滚
     */
    private Integer state;

    /**
     * 交易nonce
     */
    private String nonce;

    /**
     * 交易时间
     */
    private Long timestamp;
    /**
     * 交易文本
     */
    private String note;

    /**
     * 手续费
     */
    private BigDecimal fee;
    /**
     * 链上实际消耗手续费
     */
    private BigDecimal transactionFee;

    /**
     * 资产id
     */
    private String asset;
    /**
     * 精度
     */
    private Integer decimal;
    /**
     * 当前时间
     */
    private Long currentTime;
    /**
     * 有效时间
     */
    private Long expireTime;
    /**
     * 交易有效高度
     */
    private Long expireBlockHeight;
    /**
     * refer 高度
     */
    private Long referBlockHeight;

    /**
     * 链id
     */
    private String chainId;

    /**
     * utxo input
     */
    private List<WaasTransactionDTO.VinItem> vin;
    /**
     * 交易output
     */
    private List<WaasTransactionDTO.VoutItem> vout;

}
