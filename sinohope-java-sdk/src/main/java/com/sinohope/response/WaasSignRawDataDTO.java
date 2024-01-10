package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WaasSignRawDataDTO {
    /**
     * sinohope Id
     * <p> sinohope 为每个业务生成的唯一id <p/>
     */
    private String sinoId;
    /**
     * 签名结果
     */
    private String signature;
    /**
     * 状态（进行中：0，成功：1，失败：2）
     */
    private Integer state;

}
