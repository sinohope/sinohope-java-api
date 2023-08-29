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
  ;
}
