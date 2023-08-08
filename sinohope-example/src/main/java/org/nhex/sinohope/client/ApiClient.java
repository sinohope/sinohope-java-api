package org.nhex.sinohope.client;

import org.nhex.sinohope.pojo.SettlementFinishDTO;

/**
 * @author wangfengchen
 */
public interface ApiClient {

  ResultData<Void> add(WaasApiRequest waasApiRequest);

  ResultData<Void> getValueByApiKey(String apiKey);

  ResultData<Void> existId();

  ResultData<Void> transfer(TransferRequest request);

  ResultData<Void> add2(String request);

  ResultData<Void> add3(SettlementFinishDTO request);


}
