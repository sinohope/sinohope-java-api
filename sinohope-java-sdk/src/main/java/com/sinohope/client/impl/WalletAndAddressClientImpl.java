package com.sinohope.client.impl;

import com.sinohope.client.WalletAndAddressClient;
import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.WalletAndAddressService;
import com.sinohope.sign.ECDSA;

import java.util.List;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

/**
 * @Author sunlf
 * @Date 2023/8/15
 */
public class WalletAndAddressClientImpl implements WalletAndAddressClient {
  private final WalletAndAddressService walletAndAddressService;

  public WalletAndAddressClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
    walletAndAddressService = createService(WalletAndAddressService.class, signer, env, publicKey, privateKey);
  }

  @Override
  public ResultData<List<WaasChainVO>> getSupportedChains() {
    return executeSync(walletAndAddressService.getSupportedChains());
  }


  @Override
  public ResultData<WaasGetWalletBalanceDTO> getAddressBalance(WaasGetAddressBalanceParam param) {
    return executeSync(walletAndAddressService.getAddressBalance(param));
  }



  @Override
  public ResultData<List<ApiWaasWalletInfoVO>> createBatchWallet(WaasCreateBatchWalletParam param) {
    return executeSync(walletAndAddressService.createBatchWallet(param));
  }

  @Override
  public ResultData<List<ApiWaasVaultInfo>> queryVaults() {
    return executeSync(walletAndAddressService.queryVaults());
  }

  @Override
  public ResultData<PageData<ApiWaasWalletInfoVO>> listWallets(WaasListWalletsParam param) {
    return executeSync(walletAndAddressService.listWallets(param));
  }

  @Override
  public ResultData<List<WaasAddressVo>> generateChainAddresses(WaasGenerateChainAddressParam param) {
    return executeSync(walletAndAddressService.generateChainAddresses(param));
  }

  @Override
  public ResultData<List<WassCoinDTO>> getSupportedCoins(WaasChainParam param) {
    return executeSync(walletAndAddressService.getSupportedCoins(param));
  }

  @Override
  public ResultData<List<WaasListAddedChainsDTO>> listAddedChains(WaasListAddedChainsParam param) {
    return executeSync(walletAndAddressService.listAddedChains(param));
  }

  @Override
  public ResultData<PageData<WaasGetWalletBalanceDTO>> getWalletBalance(WaasGetWalletBalanceParam param) {
    return executeSync(walletAndAddressService.getWalletBalance(param));
  }

  @Override
  public ResultData<PageData<WaasAddressInfo>> listAddresses(WaasListAddressesParam param) {
    return executeSync(walletAndAddressService.listAddresses(param));
  }

  @Override
  public ResultData<WaasAddressCheckDTO> checkAddress(WaasAddressCheckParam param) {
    return executeSync(walletAndAddressService.checkAddress(param));
  }

  @Override
  public ResultData<PageData<WaasTransferAddressBookDTO>> transferAddressBook(WaasTransferAddressBookParam req) {
    return executeSync(walletAndAddressService.transferAddressBook(req));
  }

  @Override
  public ResultData<WaasTransferAddressSwitchDTO> transferRiskControlSwitch(WaasVaultIdDTO param) {
    return executeSync(walletAndAddressService.transferRiskControlSwitch(param));
  }



}
