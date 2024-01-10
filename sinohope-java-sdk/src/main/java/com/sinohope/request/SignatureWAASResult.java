package com.sinohope.request;


import lombok.Data;

@Data
public class SignatureWAASResult {

    /**
     * sinoId
     */
    private String sinoId;
    /**
     * 签名信息
     */
    private String messageHash;

    /**
     * 签名结果
     */
    private String signature;
    /**
     * 状态（进行中：0，成功：1，失败：2）
     */
    private Integer state;

}
