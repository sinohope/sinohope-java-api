package org.nhex.sinohope.client;

import lombok.Data;

import java.util.Set;

/**
 * @author wangfengchen
 */
@Data
public class WaasApiRequest {

  private Integer apiType;
  private Set<String> apiList;

}
