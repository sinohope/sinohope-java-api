package com.sinohope.client;

import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;

import java.util.List;

public interface ApiClient {
    ResultData<List<ApiWaasWalletInfoVO>> createBatchWallet(WaasCreateBatchWalletParam param);
    ResultData<PageData<ApiWaasWalletInfoVO>> listWallets(WaasListWalletsParam param);
    ResultData<List<WaasAddressInfo>> generateChainAddresses(WaasGenerateChainAddressParam param) ;
    //
    ResultData<PageData<WaasAddressInfo>> listAddresses(WaasListAddressesParam param);
    ResultData<List<WaasListAddedChainsDTO>> listAddedChains(WaasListAddedChainsParam param);
    ResultData<WaasGetWalletBalanceDTO> getAddressBalance(WaasGetAddressBalanceParam param);

    ResultData<List<WaasChainVO>> getSupportedChains(GetSupportedChainsReq req);

    ResultData<List<WassCoinDTO>> getSupportedCoins(WaasChainParam param);

    ResultData<List<ApiWaasVaultInfo>> getVaults(GetVaultsReq req);

    ResultData<FeeDTO> transactionFee(TransactionFeeParam param);

    ResultData<WaasTransactionDTO> createTransfer(WalletTransactionSendWAASParam param);

    ResultData<WaasTransactionDTO> speedupWaasTransfer(WalletTransactionSpeedupWAASParam param);

    ResultData<WaasTransactionDTO> waasCancelTransaction(WalletTransactionSpeedupWAASParam param);

    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTransactionId(WalletTransactionQueryWAASSinoIdParam sinoIds);

    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTxHash(WalletTransactionQueryWAASTxHashdParam txHash);

    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByRequestId(WalletTransactionQueryWAASRequestIdParam param);

    ResultData<PageData<WaasTransactionDTO>> walletTransactionList(WalletTransactionQueryWAASParam param);

    ResultData<WaasAddressCheckDTO> isValidAddress(WaasAddressCheckParam param);

}
