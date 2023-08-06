//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.nhex.sinohope.client;

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
