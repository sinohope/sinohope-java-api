package org.nhex.sinohope.client;

import org.nhex.sinohope.api.sign.ECDSA;
import org.nhex.sinohope.pojo.SettlementFinishReqDemo;

import java.util.Map;

import static org.nhex.sinohope.client.ApiServiceGenerator.createService;
import static org.nhex.sinohope.client.ApiServiceGenerator.executeSync;

/**
 * @author wangfengchen
 */
public class ApiClientImpl implements ApiClient {

  private final ApiService apiService;

  public ApiClientImpl(ECDSA signer, Env env) {
    apiService = createService(ApiService.class, signer, env);
  }


  @Override
  public ResultData<Void> add(WaasApiRequest waasApiRequest) {
    return executeSync(apiService.add(waasApiRequest));
  }

  @Override
  public ResultData<Void> getValueByApiKey(String apiKey) {
    return executeSync(apiService.getValueByApiKey(apiKey));
  }

  @Override
  public ResultData<Void> existId() {
    return executeSync(apiService.existId());
  }

  @Override
  public ResultData<Void> transfer(TransferRequest request) {
    return executeSync(apiService.transfer(request));
  }

  @Override
  public ResultData<Void> add2(String request) {
    return executeSync(apiService.add2(request));
  }

  @Override
  public ResultData<Void> add3(SettlementFinishReqDemo request) {
    return executeSync(apiService.add3(request));
  }

}
