package com.sinohope.response;

import lombok.Data;

import java.util.List;

@Data
public class WaasTransactionDTO {



    private static final String actionTypeTransfer = "Transfer";
    private static final String actionTypeWeb3Tx = "Web3Tx";
    /**
     * sinoId
     */
    private Long  sinoId;
    private String requestId;
    private Long replacedSinoId;

    /**
     * 网络
     */
    private String chainSymbol;
    private Integer txDirection;
    private Integer state;
    private String note;

    /**
     * 签名交易信息
     */
    private TxInfo transaction;



    @Data
    public class TxInfo{
        private String txHash;
        private String actionType;
        /**
         * 资产id
         */
        private String assetId;

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
         * 手续费
         */
        private String fee;

        /**
         * 手续费资产
         */
        private String feeAsset;
        /**
         * 手续费Price
         */
        private String gasPrice;
        private Integer feeAssetDecimal;
        private String usedFee;
        /**
         * 手续费Step
         */
        private String gasLimit;

        /**
         * 交易nonce
         */
        private String nonce;
        private String inputData;
        /**
         * 精度
         */
        private Integer decimal;
        private String contractAddress;

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
         * utxo input
         */
        private List<VinItem> vin;
        /**
         * 交易output
         */
        private List<VoutItem> vout;
    }
    @Data
    public class VinItem{
        /**
         * 交易id
         */
        private Long id;
        /**
         * 交易hash
         */
        private String hash;
        /**
         * 交易index
         */
        private String voutIndex;
        /**
         * 交易地址
         */
        private String address;
        /**
         * 交易金额
         */
        private String amount;
        /**
         * 交易资产
         */
        private String asset;
    }
    @Data
    public class VoutItem{
        /**
         * 交易资产
         */
        private String asset;
        /**
         * 交易地址
         */
        private String address;
        /**
         * 交易金额
         */
        private String amount;
    }

}
