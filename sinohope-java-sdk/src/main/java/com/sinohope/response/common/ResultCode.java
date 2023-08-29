package com.sinohope.response.common;

/**
 * @author wangfengchen
 */
public enum ResultCode implements IResultCode {
  SUCCESS(200, "ok"),
  PARAM_ERROR(400, "param error"),
  INTERNAL_SERVER_ERROR(500, "service internal exception");

  private int code;
  private String msg;

  public int getCode() {
    return this.code;
  }

  public String getMsg() {
    return this.msg;
  }

  private ResultCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
