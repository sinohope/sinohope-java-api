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

}
