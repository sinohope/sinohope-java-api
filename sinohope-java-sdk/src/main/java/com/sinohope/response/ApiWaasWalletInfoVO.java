package com.sinohope.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiWaasWalletInfoVO implements Serializable {
  /**
   * 请求唯一值
   */
  private String requestId;
  /**
   * 钱包id
   */
  private String walletId;
  /**
   * 钱包名称
   */
  private String walletName;
  /**
   * 高级功能开关 (关：0，开：1)
   */
  private Integer advancedEnabled;
}
