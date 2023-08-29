package com.sinohope.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author renshihan
 */
@Data
public class GetSupportedChainsReq {
    @NotNull
    private String vaultId;
}
