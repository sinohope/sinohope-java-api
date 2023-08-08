package org.nhex.sinohope.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author lishuo
 * @Date 2023-07-04 18:30
 **/
@Data
@Builder
public class SettlementFinishDTO {
  private String settlementId;
  private String cvaId;
  private List<SettlementFinishDetailDTO> data;
}


