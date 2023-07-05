package org.nhex.sinohope.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author lishuo
 * @Date 2023-07-04 18:31
 **/
@Data
@Builder
public class SettlementFinishDetailReqDto {
    private String assetId;
    private String status;
    private String txHash;
}

