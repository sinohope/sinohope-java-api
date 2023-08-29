package com.sinohope.client;

import com.sinohope.request.*;
import com.sinohope.response.ApiWaasVaultInfo;
import com.sinohope.response.ApiWaasWalletInfoVO;
import com.sinohope.response.WaasAddressCheckDTO;
import com.sinohope.response.WaasAddressInfo;
import com.sinohope.response.WaasAddressVo;
import com.sinohope.response.WaasChainVO;
import com.sinohope.response.WaasGetWalletBalanceDTO;
import com.sinohope.response.WaasListAddedChainsDTO;
import com.sinohope.response.WaasTransferAddressBookDTO;
import com.sinohope.response.WaasTransferAddressSwitchDTO;
import com.sinohope.response.WassCoinDTO;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;

import java.util.List;

/**
 * 钱包及地址client
 *
 * @Author sunlf
 * @Date 2023/8/15
 */
public interface WalletAndAddressClient {

  ResultData<List<WaasChainVO>> getSupportedChains();


  ResultData<WaasGetWalletBalanceDTO> getAddressBalance(WaasGetAddressBalanceParam param);

  ResultData<List<ApiWaasWalletInfoVO>> createBatchWallet(WaasCreateBatchWalletParam param);

  ResultData<List<ApiWaasVaultInfo>> queryVaults();
  ResultData<PageData<ApiWaasWalletInfoVO>> listWallets(WaasListWalletsParam param);
  ResultData<List<WaasAddressVo>> generateChainAddresses(WaasGenerateChainAddressParam param);

  ResultData<List<WassCoinDTO>> getSupportedCoins(WaasChainParam param);


  ResultData<List<WaasListAddedChainsDTO>> listAddedChains(WaasListAddedChainsParam param);

  ResultData<PageData<WaasGetWalletBalanceDTO>> getWalletBalance(WaasGetWalletBalanceParam param);

  ResultData<PageData<WaasAddressInfo>> listAddresses(WaasListAddressesParam param);

  ResultData<WaasAddressCheckDTO> checkAddress(WaasAddressCheckParam param);


  ResultData<PageData<WaasTransferAddressBookDTO>> transferAddressBook(WaasTransferAddressBookParam req);;


  ResultData<WaasTransferAddressSwitchDTO> transferRiskControlSwitch(WaasVaultIdDTO param);

}
