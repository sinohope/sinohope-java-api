package com.sinohope.constant;

/**
 * @Author sunlf
 * @Date 2023/8/24
 */
public class ErrorCodeConstant {

  /**
   * 签名失败
   */
  public static final Integer SIGNATURE_ERROR = 1013;
  /**
   * 不支持的请求类型(仅支持GET、POST)
   */
  public static final Integer UN_SUPPORT_METHOD = 1014;
  /**
   * 缺少签名参数
   */
  public static final Integer PARAM_ERROR_CODE = 1015;
}
