package com.sinohope.client;

import com.sinohope.client.impl.*;
import com.sinohope.constant.ErrorCodeConstant;
import com.sinohope.exception.MpcException;
import com.sinohope.sign.ECDSA;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author wangfengchen
 */
public class ClientFactory {

  private final ECDSA signer;

  private final String baseUrl;

  private final String publicKey;

  private final String privateKey;


  private ClientFactory(ECDSA signer, String baseUrl, String publicKey, String privateKey) {
    this.signer = signer;
    this.baseUrl = baseUrl;
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  public static ClientFactory newInstance(ECDSA signer, String env, String publicKey, String privateKey) {
    return new ClientFactory(signer, env, publicKey, privateKey);
  }


  public MpcNodeClient newMpcNodeClient() {
    this.check();
    return new MpcNodeClientImpl(signer, baseUrl, publicKey, privateKey);
  }


  public WalletAndAddressClient newWalletAndAddressClient() {
    this.check();
    return new WalletAndAddressClientImpl(signer, baseUrl, publicKey, privateKey);
  }


  public TransactionClient newTransactionClient() {
    this.check();
    return new TransactionClientImpl(signer, baseUrl, publicKey, privateKey);
  }


  public SeniorClient newSeniorClient() {
    this.check();
    return new SeniorClientClientImpl(signer, baseUrl, publicKey, privateKey);
  }

  public Brc20Client newBrc20Client() {
    this.check();
    return new Brc20ClientImpl(signer, baseUrl, publicKey, privateKey);
  }

  public RunesClient newRunesClient() {
    this.check();
    return new RunesClientImpl(signer, baseUrl, publicKey, privateKey);
  }



  public StakingClient newStakingClient() {
    this.check();
    return new StakingClientImpl(signer, baseUrl, publicKey, privateKey);
  }


  public ApiClient newApiClient() {
    this.check();
    return new ApiClientImpl(signer, baseUrl, publicKey, privateKey);
  }



  void check(){
    if (StringUtils.isBlank(this.baseUrl)) {
      throw new MpcException(ErrorCodeConstant.PARAM_ERROR_CODE,"baseurl can not be empty");
    }
    if (StringUtils.isBlank(this.publicKey)) {
      throw new MpcException(ErrorCodeConstant.PARAM_ERROR_CODE,"publicKey can not be empty");
    }
    if (StringUtils.isBlank(this.privateKey)) {
      throw new MpcException(ErrorCodeConstant.PARAM_ERROR_CODE,"privateKey can not be empty");
    }
    if (Objects.isNull(signer)) {
      throw new MpcException(ErrorCodeConstant.PARAM_ERROR_CODE,"signer can not be null");
    }
  }

}
