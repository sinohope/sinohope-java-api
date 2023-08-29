package com.sinohope.response;

//import cn.hutool.json.JSONUtil;
//import com.nhtech.mpc.common.domain.entity.ChainAsset;
//import com.nhtech.mpc.common.domain.entity.TblTransaction;
//import com.nhtech.mpc.common.domain.entity.TransactionEntity;
//import com.nhtech.mpc.common.dto.VinDTO;
//import com.nhtech.mpc.common.dto.VoutDTO;
//import com.nhtech.mpc.common.utils.AmountUtil;
//import com.nhtech.mpc.common.utils.ParamUtils;
import lombok.Data;

import java.util.List;

@Data
public class CreateSettlementTxRes {
    /**
     * sinoId
     */
    private Long  sinoId;
    /**
     * 网络
     */
    private String chainSymbol;
    /**
     * 交易类型 eth交易 1：Eip2930 2：Eip1559
     */
    private String txType;
    /**
     * 签名前信息
     */
    private String hasToBeSigned;
    /**
     * 签名交易信息
     */
    private TxInfo data;

    /**
     * hdpath
     */
    private String hdpath;
    private String cryptography;


    @Data
    public class TxInfo{
        /**
         * 资产id
         */
        private String asset;

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
//        /   eth交易 1：Eip2930 2：Eip155
        /**
         * 交易类型
         */
        private Integer txType ;
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
         * 链id
         */
        private String chainId;
        /**
         * 交易nonce
         */
        private String nonce;
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
         * utxo input
         */
        private List<VinItem> vin;
        /**
         * 交易output
         */
        private List<VoutItem> vout;
        private String funName;
        private List<String> params;
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

//    public void setTransaction(TblTransaction tbl, ChainAsset chainAsset,ChainAsset feeChainAsset,String funName,List<String> params){
//        TxInfo data = new TxInfo();
//        data.setAsset(chainAsset.getAssetId());
//        data.setDecimal(chainAsset.getDecimals());
//        data.setCurrentTime(System.currentTimeMillis());
//        data.setExpireTime(0L);
//        data.setExpireBlockHeight(0L);
//        data.setReferBlockHeight(0L);
////        eth交易 1：Eip2930 2：Eip1559
//        data.setTxType(1);
//        data.setFrom(tbl.getFromAddress());
//        data.setFromTag(tbl.getFromTag());
//        data.setTo(tbl.getToAddress());
//        data.setToTag(tbl.getToTag());
//        data.setAmount(AmountUtil.rvZeroAndDot(tbl.getAmount()));
//        data.setFee(AmountUtil.rvZeroAndDot(tbl.getFee()));
//        data.setFeeAsset(feeChainAsset.getAssetId());
//        data.setFeePrice(AmountUtil.rvZeroAndDot(tbl.getGasPrice()));
//        data.setFeeStep(AmountUtil.rvZeroAndDot(tbl.getGas()));
//        data.setChainId(tbl.getChainId()+"");
//        data.setNonce(tbl.getNonce()+"");
//        String extraData = tbl.getExtraData();
//        if(ParamUtils.isNotEmpty(extraData)){
//            TransactionEntity transactionEntity = JSONUtil.toBean(extraData,TransactionEntity.class);
//            List<VinDTO> vinDtos = ParamUtils.isEmpty(transactionEntity.getVinList())? new ArrayList<>():transactionEntity.getVinList();
//            List<VinItem> vin = vinDtos.stream().map(dto -> {
//                VinItem item = new VinItem();
//                item.setId(dto.getId());
//                item.setHash(dto.getTransactionHash());
//                item.setAddress(dto.getAddress());
//                item.setAsset(dto.getAssetChainName());
//                item.setAmount(AmountUtil.rvZeroAndDot(dto.getAmount()));
//                item.setVoutIndex(dto.getVoutIndex() + "");
//                return item;
//            }).collect(Collectors.toList());
//            data.setVin(vin);
//            List<VoutDTO> voutDTOS = ParamUtils.isEmpty(transactionEntity.getVoutList())? new ArrayList<>():transactionEntity.getVoutList();
//            List<VoutItem> voutItems = voutDTOS.stream().map(dto -> {
//                VoutItem item = new VoutItem();
//                item.setAmount(AmountUtil.rvZeroAndDot(dto.getAmount()));
//                item.setAddress(dto.getAddress());
//                return item;
//            }).collect(Collectors.toList());
//            data.setVout(voutItems);
//        }
//        data.setFunName(funName);
//        data.setParams(params);
//        this.data=data;
//    }

}
