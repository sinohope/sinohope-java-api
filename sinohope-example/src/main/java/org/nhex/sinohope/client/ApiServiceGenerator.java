package org.nhex.sinohope.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.nhex.sinohope.api.sign.ECDSA;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author wangfengchen
 */
public class ApiServiceGenerator {

  private static final OkHttpClient sharedClient;
  private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

  static {
    Dispatcher dispatcher = new Dispatcher();
    dispatcher.setMaxRequestsPerHost(500);
    dispatcher.setMaxRequests(500);
    sharedClient = new OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .dispatcher(dispatcher)
        .pingInterval(20, TimeUnit.SECONDS)
        .build();
  }

  public static <S> S createService(Class<S> serviceClass, ECDSA signer, Env env) {
    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
        .baseUrl(env.host)
        .addConverterFactory(converterFactory);
    AuthenticationInterceptor interceptor = new AuthenticationInterceptor(signer, env.publicKey, env.privateKey);
    OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
    retrofitBuilder.client(adaptedClient);
    Retrofit retrofit = retrofitBuilder.build();
    return retrofit.create(serviceClass);
  }

  public static <T> T executeSync(Call<T> call) {
    try {
      Response<T> response = call.execute();
      if (response.isSuccessful()) {
        return response.body();
      } else {
        return (T) getApiError(response);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static ResultData getApiError(Response<?> response) throws IOException {
    ResponseBody errorBody = response.errorBody();
    ObjectMapper mapper = new ObjectMapper();
    String s = errorBody.string();
    if (StringUtils.isBlank(s)) {
      return ResultData.failed(response.code(), response.message());
    }
    return mapper.readValue(s, ResultData.class);
  }

  public static OkHttpClient getSharedClient() {
    return sharedClient;
  }
}
