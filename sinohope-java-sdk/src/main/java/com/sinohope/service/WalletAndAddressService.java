package com.sinohope.service;

import com.sinohope.request.WaasAddressCheckParam;
import com.sinohope.request.WaasChainParam;
import com.sinohope.request.WaasCreateBatchWalletParam;
import com.sinohope.request.WaasGenerateChainAddressParam;
import com.sinohope.request.WaasGetAddressBalanceParam;
import com.sinohope.request.WaasGetWalletBalanceParam;
import com.sinohope.request.WaasListAddedChainsParam;
import com.sinohope.request.WaasListAddressesParam;
import com.sinohope.request.WaasListWalletsParam;
import com.sinohope.request.WaasTransferAddressBookParam;
import com.sinohope.request.WaasVaultIdDTO;
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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

/**
 * @Author sunlf
 * @Date 2023/8/15
 */
public interface WalletAndAddressService {

  @POST("/v1/waas/common/get_supported_chains")
  Call<ResultData<List<WaasChainVO>>> getSupportedChains();


  /**
   * 获取余额
   *
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/wallet/get_address_balance")
  Call<ResultData<WaasGetWalletBalanceDTO>> getAddressBalance(@Body WaasGetAddressBalanceParam param);

  /**
   * 创建钱包
   *
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/create_wallets")
  Call<ResultData<List<ApiWaasWalletInfoVO>>> createBatchWallet( @Body WaasCreateBatchWalletParam param);
  /**
   * 查询金库
   *
   * @param
   * @return
   */
  @POST("/v1/waas/common/get_vaults")
  Call<ResultData<List<ApiWaasVaultInfo>>> queryVaults();
  /**
   * 查询钱包
   *
   * @param
   * @return
   */
  @POST("/v1/waas/mpc/wallet/list_wallets")
  Call<ResultData<PageData<ApiWaasWalletInfoVO>>> listWallets(@Body WaasListWalletsParam param);

  /**
   * 生成链
   *
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/wallet/generate_chain_addresses")
  Call<ResultData<List<WaasAddressVo>>> generateChainAddresses(@Body WaasGenerateChainAddressParam param);
  /**
   * 链支持的币种列表
   *
   * @param param
   * @return
   */
  @POST("/v1/waas/common/get_supported_coins")
  Call<ResultData<List<WassCoinDTO>>> getSupportedCoins(@Body WaasChainParam param);
  /**
   * 查询指定钱包下已添加地址的链及其首个地址信息
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/wallet/list_added_chains")
  Call<ResultData<List<WaasListAddedChainsDTO>>> listAddedChains(@Body WaasListAddedChainsParam param);


  /**
   * 查询指定钱包所有币种的余额信息
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/wallet/get_wallet_balance")
  Call<ResultData<PageData<WaasGetWalletBalanceDTO>>> getWalletBalance(@Body WaasGetWalletBalanceParam param);


  /**
   * 检查币种地址是否正确
   * @param param
   * @return
   */
  @POST("/v1/waas/mpc/is_valid_address")
  Call<ResultData<WaasAddressCheckDTO>> checkAddress(@Body WaasAddressCheckParam param);



  /**
   * 查询链地址
   *
   * @param
   */
  @POST("/v1/waas/mpc/wallet/list_addresses")
  Call<ResultData<PageData<WaasAddressInfo>>> listAddresses(@Body WaasListAddressesParam param);

  /**
   * 当前金库设置开关以后,支持转账的地址簿
   * @param
   */
  @POST("/v1/waas/mpc/wallet/transfer_address_book")
  Call<ResultData<PageData<WaasTransferAddressBookDTO>>> transferAddressBook(@Body  WaasTransferAddressBookParam req);


  /**
   * 查询当前金库是否设置了风控开关
   *
   * @param
   */
  @POST("/v1/waas/mpc/wallet/transfer_risk_control_switch")
  Call<ResultData<WaasTransferAddressSwitchDTO>> transferRiskControlSwitch(@Body WaasVaultIdDTO param);


}
