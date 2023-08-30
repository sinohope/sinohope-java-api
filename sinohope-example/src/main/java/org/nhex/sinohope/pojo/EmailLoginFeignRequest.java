package org.nhex.sinohope.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wangfengchen
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmailLoginFeignRequest extends LoginBaseRequest {

  /**
   * 业务类型：1001：信托，1002：MPC
   */
  private Integer exchangeId;

  /**
   * 邮箱
   */
  private String email;


}
