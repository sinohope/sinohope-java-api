package com.sinohope.client.impl;

import com.sinohope.client.ApiClient;
import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.ApiService;
import com.sinohope.service.StakingService;
import com.sinohope.sign.ECDSA;

import java.util.List;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

public class ApiClientImpl implements ApiClient {

    private ApiService apiService;
    public ApiClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
        apiService = createService(ApiService.class, signer, env, publicKey, privateKey);
    }
    @Override
    public ResultData<List<ApiWaasWalletInfoVO>> createBatchWallet(WaasCreateBatchWalletParam param) {
        return executeSync(apiService.createBatchWallet(param));
    }

    @Override
    public ResultData<PageData<ApiWaasWalletInfoVO>> listWallets(WaasListWalletsParam param) {
        return executeSync(apiService.listWallets(param));
    }

    @Override
    public ResultData<List<WaasAddressInfo>> generateChainAddresses(WaasGenerateChainAddressParam param) {
        return executeSync(apiService.generateChainAddresses(param));
    }

    @Override
    public ResultData<PageData<WaasAddressInfo>> listAddresses(WaasListAddressesParam param) {
        return executeSync(apiService.listAddresses(param));
    }

    @Override
    public ResultData<List<WaasListAddedChainsDTO>> listAddedChains(WaasListAddedChainsParam param) {
        return executeSync(apiService.listAddedChains(param));
    }

    @Override
    public ResultData<WaasGetWalletBalanceDTO> getAddressBalance(WaasGetAddressBalanceParam param) {
        return executeSync(apiService.getAddressBalance(param));
    }

    @Override
    public ResultData<List<WaasChainVO>> getSupportedChains(GetSupportedChainsReq req) {
        return executeSync(apiService.getSupportedChains(req));
    }

    @Override
    public ResultData<List<WassCoinDTO>> getSupportedCoins(WaasChainParam param) {
        return executeSync(apiService.getSupportedCoins(param));
    }

    @Override
    public ResultData<List<ApiWaasVaultInfo>> getVaults(GetVaultsReq req) {
        return executeSync(apiService.getVaults(req));
    }

    @Override
    public ResultData<FeeDTO> transactionFee(TransactionFeeParam param) {
        return executeSync(apiService.transactionFee(param));
    }

    @Override
    public ResultData<WaasTransactionDTO> createTransfer(WalletTransactionSendWAASParam param) {
        return executeSync(apiService.createTransfer(param));
    }

    @Override
    public ResultData<WaasTransactionDTO> speedupWaasTransfer(WalletTransactionSpeedupWAASParam param) {
        return executeSync(apiService.speedupWaasTransfer(param));
    }

    @Override
    public ResultData<WaasTransactionDTO> waasCancelTransaction(WalletTransactionSpeedupWAASParam param) {
        return executeSync(apiService.waasCancelTransaction(param));
    }

    @Override
    public ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTransactionId(WalletTransactionQueryWAASSinoIdParam sinoIds) {
        return executeSync(apiService.walletTransactionListByTransactionId(sinoIds));
    }

    @Override
    public ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTxHash(WalletTransactionQueryWAASTxHashdParam txHash) {
        return executeSync(apiService.walletTransactionListByTxHash(txHash));
    }

    @Override
    public ResultData<PageData<WaasTransactionDTO>> walletTransactionListByRequestId(WalletTransactionQueryWAASRequestIdParam param) {
        return executeSync(apiService.walletTransactionListByRequestId(param));
    }

    @Override
    public ResultData<PageData<WaasTransactionDTO>> walletTransactionList(WalletTransactionQueryWAASParam param) {
        return executeSync(apiService.walletTransactionList(param));
    }

    @Override
    public ResultData<WaasAddressCheckDTO> isValidAddress(WaasAddressCheckParam param) {
        return executeSync(apiService.isValidAddress(param));
    }

    @Override
    public ResultData collectionStrategy(CollectionStrategyReq req) {
        return executeSync(apiService.collectionStrategy(req));
    }

    @Override
    public ResultData<PageData<CollectStrategyRes>> collectionStrategyLists(CollectionStrategyListsReq req) {
        return executeSync(apiService.collectionStrategyLists(req));
    }

    @Override
    public ResultData setGasStation(SetGasStationReq req) {
        return executeSync(apiService.setGasStation(req));
    }

    @Override
    public ResultData<List<GasStationRes>> gasStationLists(GasStationListsReq req) {
        return executeSync(apiService.gasStationLists(req));
    }

    @Override
    public ResultData setDelegateEnergy(SetDelegateEnergyReq req) {
        return executeSync(apiService.setDelegateEnergy(req));
    }
}
