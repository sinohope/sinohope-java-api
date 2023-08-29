package com.sinohope.request;

import lombok.Data;

@Data
public class WaasNotifyReqParam {

    /**
     * 回调请求类型 (充值：1，提现：2)
     */
    private Integer requestType ;

    /**
     * 请求的唯一id,多次调用不便
     */
    private String requestId;
    /**
     * 回调请求的详细信息；每种类型的回调请求对应于不同的requestDetail结构；格式为序列化的 JSON 字符串
     */
    private String requestDetail;
    /**
     * 与回调请求相关的其他信息；每种类型的回调请求对应于不同的extra_info结构；格式为序列化 JSON 字符串
     */
    private String extraInfo;


}
