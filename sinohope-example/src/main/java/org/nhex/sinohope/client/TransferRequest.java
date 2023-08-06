package org.nhex.sinohope.client;

import lombok.Data;

/**
 * @author wangfengchen
 */
@Data
public class TransferRequest {

  private String walletId;
  private String chainId;
  private String assetId;
  private String amount;
  private String from;
  private String to;
  private String gasLimit;
  private String gasPrice;
  private String fee;
  private String gaAuthCode;
  private Integer amountType;
}
