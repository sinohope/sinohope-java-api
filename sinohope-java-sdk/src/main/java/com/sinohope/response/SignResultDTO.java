package com.sinohope.response;

import lombok.Data;

@Data
public class SignResultDTO {
    private String requestId;
    private String sinoId;
    private String message;
    private String signature;
    private Integer state;
}
