package com.sinohope.response;

import lombok.Data;

@Data
public class StakingTx {
    private String tx_hex;
    private Integer output_index;
    private String start_timestamp;
    private Long start_height;
    private Long timelock;

}
