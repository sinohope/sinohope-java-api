package com.sinohope.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
@ToString
public class WaasVaultIdDTO implements Serializable {
    /**
     * 金库id
     */
    private String vaultId;
}
