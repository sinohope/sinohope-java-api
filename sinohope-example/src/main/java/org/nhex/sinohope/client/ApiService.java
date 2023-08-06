package org.nhex.sinohope.client;

import org.nhex.sinohope.pojo.SettlementFinishReqDemo;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

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

  @FormUrlEncoded
  @POST("/user-auth-c/ua/waas/add")
  Call<ResultData<Void>> add2(@FieldMap Map<String, String> request);

  @POST("/user-auth-c/ua/waas/add")
  Call<ResultData<Void>> add3(@Body SettlementFinishReqDemo request);



}
