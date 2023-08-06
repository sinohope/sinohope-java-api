package org.nhex.sinohope.client;

import java.util.Set;

/**
 * @author wangfengchen
 */
public class WaasApiRequest {

  private Integer apiType;
  private Set<String> apiList;

  public Integer getApiType() {
    return apiType;
  }

  public void setApiType(Integer apiType) {
    this.apiType = apiType;
  }

  public Set<String> getApiList() {
    return apiList;
  }

  public void setApiList(Set<String> apiList) {
    this.apiList = apiList;
  }
}
