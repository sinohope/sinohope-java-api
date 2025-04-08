package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
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



    /**
     * 交易列表，查询充值提现所有的交易记录
     *
     * @param param
     * @return
     */
    @POST("/v1/api/transaction/list_transactions")
    Call<ResultData> walletTransactionList(@Body WalletTransactionQueryWAASParam param);


    /**
     * 检查币种地址是否正确
     * @param param
     * @return
     */
    @POST("/v1/api/common/is_valid_address")
    Call<ResultData<WaasAddressCheckDTO>> isValidAddress(@Body WaasAddressCheckParam param);


    /**
     * 设置归集策略
     * @param req
     * @return
     */
    @POST("/v1/api/sweep/set_strategy")
    Call<ResultData> collectionStrategy(@Body CollectionStrategyReq req);


    /**
     * 查询归集策略
     * @param param
     * @return
     */
    @POST("/v1/api/sweep/strategy_lists")
    Call<ResultData<PageData<CollectStrategyRes>>> collectionStrategyLists(@Body CollectionStrategyListsReq param);


    /**
     * 设置gas加油站
     * @param param
     * @return
     */
    @POST("/v1/api/sweep/set_gas_station")
    Call<ResultData> setGasStation(@Body SetGasStationReq param);


    /**
     * 查询gas加油站
     * @param param
     * @return
     */
    @POST("/v1/api/sweep/gas_station_lists")
    Call<ResultData<List<GasStationRes>>> gasStationLists(@Body GasStationListsReq param);

    /**
     * 配置能量租凭
     * @param param
     * @return
     */
    @POST("/v1/api/config/set_delegate_energy")
    Call<ResultData<List<GasStationRes>>> setDelegateEnergy(@Body SetDelegateEnergyReq param);

    /**
     * 配置waas高级交易规则
     * @param param
     * @return
     */
    @POST("/v1/api/config/set_transfer_strategy")
    Call<ResultData> setTransferStrategy(@Body SetTransferStrategyReq param);


}
