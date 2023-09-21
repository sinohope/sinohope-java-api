package org.nhex.sinohope.client;

import org.nhex.sinohope.api.sign.ECDSA;
import org.nhex.sinohope.pojo.SettlementFinishDTO;
import org.nhex.sinohope.pojo.UserSdk;

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
  public ResultData<Void> add3(SettlementFinishDTO request) {
    return executeSync(apiService.add3(request));
  }

  @Override
  public ResultData<Void> testSdkGet(String key, String value) {
    return executeSync(apiService.testSdkGet(key, value));
  }

  @Override
  public ResultData<Void> testSdkPost(UserSdk request) {
    return executeSync(apiService.testSdkPost(request));
  }

  @Override
  public ResultData<Void> testSdkPostNoBody() {
    return executeSync(apiService.testSdkPostNoBody());
  }


}
