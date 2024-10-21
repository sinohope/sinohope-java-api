package com.sinohope.response;

import lombok.Data;

@Data
public class BabylonDelegationData {
    private String staking_tx_hash_hex;
    private String staker_pk_hex;
    private String finality_provider_pk_hex;
    private String state;
    private Long staking_value;
    private StakingTx staking_tx;
    private UnbondingTx unbonding_tx;
    private Boolean is_overflow;

}
