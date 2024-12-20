package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.ApiWaasVaultInfo;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {

    /**
     * 创建钱包
     * @param param
     * @return
     */
    @POST("/v1/api/address/create_wallets")
    Call<ResultData> createBatchWallet(@Body WaasCreateBatchWalletParam param);



    /**
     * 查询钱包列表
     * @param param
     * @return
     */
    @POST("/v1/api/address/list_wallets")
    Call<ResultData> listWallets(@Body WaasListWalletsParam param);

    /**
     * 生成链地址
     * @param param
     * @return
     */
    @POST("/v1/api/address/generate_chain_addresses")
    Call<ResultData> generateChainAddresses(@Body WaasGenerateChainAddressParam param);

    /**
     * 查询链地址
     * @param param
     * @return
     */
    @POST("/v1/api/address/list_addresses")
    Call<ResultData> listAddresses(@Body WaasListAddressesParam param);

    /**
     * 查询指定钱包下已添加地址的链及其首个地址信息
     * @param param
     * @return
     */
    @POST("/v1/api/address/list_added_chains")
    Call<ResultData> listAddedChains(@Body WaasListAddedChainsParam param);


    /**
     * 查询地址余额信息
     * @param param
     * @return
     */
    @POST("/v1/api/address/get_address_balance")
    Call<ResultData> getAddressBalance(@Body WaasGetAddressBalanceParam param);


    /**
     * 查询地址余额信息
     * @param param
     * @return
     */
    @POST("/v1/api/common/get_supported_chains")
    Call<ResultData> getSupportedChains(@Body GetSupportedChainsReq param);


    /**
     * 链支持的币种列表
     * @param param
     * @return
     */
    @POST("/v1/api/common/get_supported_coins")
    Call<ResultData> getSupportedCoins(@Body WaasChainParam param);


    /**
     * 金库列表
     * @param param
     * @return
     */
    @POST("/v1/api/common/get_vaults")
    Call<ResultData> getVaults(@Body GetVaultsReq param);

    /**
     * 查询交易所需交易费用（估算交易费用）
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/fee")
    Call<ResultData> transactionFee(@Body TransactionFeeParam param);
    /**
     * 发起转账：API key发起，APP端进行审核和签名；
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/create_transfer")
    Call<ResultData> createTransfer(@Body WalletTransactionSendWAASParam param);
    /**
     * 发起加速交易
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/speedup_transaction")
    Call<ResultData> speedupWaasTransfer(@Body WalletTransactionSpeedupWAASParam param);
    /**
     * 交易取消
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/cancel_transaction")
    Call<ResultData> waasCancelTransaction(@Body WalletTransactionSpeedupWAASParam param);

    /**
     * 根据sinoIds查询交易列表
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/transactions_by_sino_ids")
    Call<ResultData> walletTransactionListByTransactionId(@Body WalletTransactionQueryWAASSinoIdParam param);

    /**
     * 根据txHash查询交易列表
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/transactions_by_tx_hash")
    Call<ResultData> walletTransactionListByTxHash(@Body WalletTransactionQueryWAASTxHashdParam param);

    /**
     * 根据requestIds查询交易列表
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/transactions_by_request_ids")
    Call<ResultData> walletTransactionListByRequestId(@Body WalletTransactionQueryWAASRequestIdParam param);



}
