package com.sinohope.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author sunlf
 * @Date 2023/9/20
 */
@Data
public class TxInfo {
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
