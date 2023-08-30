package org.nhex.sinohope.pojo;

import lombok.Data;

/**
 * @author wangfengchen
 */
@Data
public class LoginBaseRequest {

  /**
   * 客户端类型：1：PC，2：Android，3：IOS，4：IPAD
   */
  private Integer clientType;

  /**
   * 踢出标签
   */
  private String kickOutTag;

  /**
   * accessToken到期时间
   */
  private Long accessTokenExpiration;

  /**
   * refreshToken到期时间
   */
  private Long refreshTokenExpiration;

}
