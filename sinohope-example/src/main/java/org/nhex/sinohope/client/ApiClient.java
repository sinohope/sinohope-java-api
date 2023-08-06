package org.nhex.sinohope.client;

import org.nhex.sinohope.pojo.SettlementFinishReqDemo;

import java.util.Map;

/**
 * @author wangfengchen
 */
public interface ApiClient {

  ResultData<Void> add(WaasApiRequest waasApiRequest);

  ResultData<Void> getValueByApiKey(String apiKey);

  ResultData<Void> existId();

  ResultData<Void> transfer(TransferRequest request);

  ResultData<Void> add2(Map<String, String> request);

  ResultData<Void> add3(SettlementFinishReqDemo request);


}
