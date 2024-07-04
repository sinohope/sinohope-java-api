package com.sinohope.request;

import lombok.Data;

@Data
public class StakingDelegationReq {
    private String stakingTxHash;

    private String stakingRequestId;

    private String stakingSinoId;
}
