package org.nhex.sinohope.client;

import org.nhex.sinohope.pojo.SettlementFinishDTO;
import org.nhex.sinohope.pojo.UserSdk;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author wangfengchen
 */
public interface ApiService {

  @POST("/user-auth-c/ua/waas/add")
  Call<ResultData<Void>> add(@Body WaasApiRequest request);

  @GET("/user-auth-c/ua/waas/getValueByApiKey")
  Call<ResultData<Void>> getValueByApiKey(@Query("apiKey") String apiKey);

  @GET("/user-auth-c/ua/user/existId")
  Call<ResultData<Void>> existId();

  @POST("/mpc-wallet/api/wallet/asset/transaction/apply/transfer")
  Call<ResultData<Void>> transfer(@Body TransferRequest request);

  @POST("/user-auth-c/ua/waas/add")
  Call<ResultData<Void>> add2(@Body String request);

  @POST("/user-auth-c/ua/waas/add")
  Call<ResultData<Void>> add3(@Body SettlementFinishDTO request);

  @GET("/test/testSdkGet")
  Call<ResultData<Void>> testSdkGet(@Query("key") String key, @Query("value") String value);

  @POST("/test/testSdkPost")
  Call<ResultData<Void>> testSdkPost(@Body UserSdk request);

  @POST("/v1/testSdkPostNoBody")
  Call<ResultData<Void>> testSdkPostNoBody();


}
