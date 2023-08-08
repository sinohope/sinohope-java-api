package org.nhex.sinohope.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author lishuo
 * @Date 2023-07-04 18:31
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettlementDTO {
  private List<SettlementDetailDTO> to_exchange;
  private List<SettlementDetailDTO> to_collateral;
  private String settlementId_ex;
  private String collateralId;
}
