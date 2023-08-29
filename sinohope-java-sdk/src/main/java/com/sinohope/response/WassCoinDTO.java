package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
@Accessors(chain = true)
public class WassCoinDTO {
    /**
     * 币种全名称
     */
    private String assetName;
    /**
     * 币标识 具有唯一性
     */
    private String assetId;
    /**
     * 币种精度
     */
    private Integer assetDecimal;

}
