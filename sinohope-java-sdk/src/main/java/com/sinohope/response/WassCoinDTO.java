package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
@Accessors(chain = true)
public class WassCoinDTO {
    /**
     *  链全名
     */
    @NotNull
    private String chainName;
    /**
     * 链名称 简称 链标识 具有唯一性
     */
    @NotNull
    private String chainSymbol;
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


    private String contractAddress;
}
