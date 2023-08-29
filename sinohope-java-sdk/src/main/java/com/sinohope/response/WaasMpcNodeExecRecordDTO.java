package com.sinohope.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class WaasMpcNodeExecRecordDTO {
    /**
     * 用户发起业务自己生成的唯一请求id
     */
    private String requestId;
    /**
     * sinoId sinohope 根据当前业务生成的唯一id
     */
    private String sinoId;
    /**
     * 请求时间
     * 格式 "2022-02-02 00:00:00"
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date requestTime;
    /**
     * 参数
     */
    private String param;
    /**
     * 失败原因
     */
    private String result;

    /**
     * 业务执行类型（KeyGen 类型请求：1，signTx 类型请求：2，signMessage 类型请求：3，signRawData 类型请求：4）
     */
    private Integer businessExecType;
    /**
     * 业务执行状态 (进行中：0，成功：1，失败：2）
     */
    private Integer businessExecStatus;
    /**
     * 失败原因
     */
    private String failedReason;



}
