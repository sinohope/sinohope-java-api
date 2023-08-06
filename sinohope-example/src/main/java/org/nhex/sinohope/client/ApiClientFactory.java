package org.nhex.sinohope.client;

import org.nhex.sinohope.api.sign.ECDSA;

public class ApiClientFactory {

  private final Env env;
  private final ECDSA signer;

  private ApiClientFactory(ECDSA signer, Env env) {
    this.signer = signer;
    this.env = env;
  }

  public static ApiClientFactory newInstance(ECDSA signer, Env env) {
    return new ApiClientFactory(signer, env);
  }

  public ApiClient newRestClient() {
    return new ApiClientImpl(signer, env);
  }

}
