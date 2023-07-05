package org.nhex.sinohope.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title:
 * @Author lishuo
 * @Date 2023-07-05 16:21
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettlementDetailDTO {
    private String amount;
    private String assetId;
    private String toTag;
    private String toAddress;
    private String fee;
}
