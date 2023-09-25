package com.sinohope.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author sunlf
 * @Date 2023/9/20
 */

@Data
public class VoutItem{

  /**
   * 交易地址
   */
  private String address;
  /**
   * 交易金额
   */
  private String amount;
}
