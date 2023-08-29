package com.sinohope.exception;

import lombok.ToString;


/**
 * @Date 2023/8/24
 */
@ToString
public class MpcException extends RuntimeException {

  /**
   *错误码
   */
  private Integer code;
  /**
   * 错误信息
   */
  private String msg;

  public MpcException(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
