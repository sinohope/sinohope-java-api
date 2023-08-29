package com.sinohope.response.common;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author wangfengchen
 */
public class ResultData<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  private int code;
  private String msg;
  private T data;
  private boolean success;
  private String requestId;

  public ResultData() {
  }

  public ResultData(int code, String msg, T data) {
    this(code, msg, data, (String) null);
  }

  public ResultData(int code, String msg, T data, String requestId) {
    this.code = code;
    this.msg = msg;
    this.data = data;
    this.success = code == ResultCode.SUCCESS.getCode();
    this.requestId = requestId;
  }

  public static <T> ResultData<T> success() {
    return new ResultData(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), (Object) null);
  }

  public static <T> ResultData<T> success(T data) {
    return new ResultData(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
  }

  public static <T> ResultData<T> failed() {
    return failed((IResultCode) ResultCode.INTERNAL_SERVER_ERROR);
  }

  public static <T> ResultData<T> failed(String msg) {
    return failed(ResultCode.INTERNAL_SERVER_ERROR, msg);
  }

  public static <T> ResultData<T> failed(int code, String msg) {
    return failed(code, msg, (String) null);
  }

  public static <T> ResultData<T> failed(int code, String msg, String requestId) {
    return new ResultData(code, msg, (Object) null, requestId);
  }

  public static <T> ResultData<T> failed(IResultCode resultCode, String msg) {
    return failed(resultCode, msg, (String) null);
  }

  public static <T> ResultData<T> failed(IResultCode resultCode) {
    return failed(resultCode, (String) null, (String) null);
  }

  public static <T> ResultData<T> failed(IResultCode resultCode, String msg, String requestId) {
    return new ResultData(resultCode.getCode(), StringUtils.isNotBlank(msg) ? msg : resultCode.getMsg(), (Object) null, requestId);
  }

  public static <T> ResultData<T> failure(int code) {
    return new ResultData(code, "" + code, (Object) null);
  }


  public int getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return this.code == ResultCode.SUCCESS.getCode();
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String toString() {
    return "ResultData{code=" + this.code + ", msg='" + this.msg + "', data=" + this.data + ", success=" + this.success + ", requestId=" + this.requestId + "}";
  }
}
