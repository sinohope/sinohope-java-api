package com.sinohope.service;

import com.sinohope.request.SignatureWAASResult;
import com.sinohope.request.TransferHistoryWAASDTO;
import com.sinohope.request.WalletTransactionCancelWAASParam;
import com.sinohope.request.WalletTransactionQueryWAASParam;
import com.sinohope.request.WalletTransactionQueryWAASRequestIdParam;
import com.sinohope.request.WalletTransactionQueryWAASSinoIdParam;
import com.sinohope.request.WalletTransactionQueryWAASTxHashdParam;
import com.sinohope.request.WalletTransactionSendDataWAASParam;
import com.sinohope.request.WalletTransactionSendWAASParam;
import com.sinohope.request.WalletTransactionSpeedupWAASParam;
import com.sinohope.request.signMessageParam;
import com.sinohope.response.CreateSettlementTxRes;
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
public interface TransactionService {

    /**
     * 交易列表，查询充值提现所有的交易记录
     *
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/transaction/list_transactions")
    Call<ResultData<PageData<TransferHistoryWAASDTO>>> walletTransactionList(@Body WalletTransactionQueryWAASParam param);


    /**
     * 根据requestIds查询交易列表
     *
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_request_ids")
    Call<ResultData<List<TransferHistoryWAASDTO>>> walletTransactionListByRequestId(@Body WalletTransactionQueryWAASRequestIdParam param);


    /**
     * 根据sinoIds查询交易列表
     *
     * @param sinoIds
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_sino_ids")
    Call<ResultData<List<TransferHistoryWAASDTO>>> walletTransactionListByTransactionId(@Body WalletTransactionQueryWAASSinoIdParam sinoIds);

    /**
     * 根据txHash查询交易列表
     *
     * @param txHash
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_tx_hash")
    Call<ResultData<List<TransferHistoryWAASDTO>>> walletTransactionListByTxHash(@Body WalletTransactionQueryWAASTxHashdParam txHash);

    /**
     * 发起转账交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/create_transfer")
    Call<ResultData<CreateSettlementTxRes>> createWaasTransfer(@Body WalletTransactionSendWAASParam param);

    /**
     * 发起加速交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/speedup_transaction")
    Call<ResultData<CreateSettlementTxRes>> speedupWaasTransfer(@Body  WalletTransactionSpeedupWAASParam param);


    /**
     * 交易取消
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/cancel_transaction")
    Call<ResultData<CreateSettlementTxRes>> waasCancelTransaction(@Body WalletTransactionCancelWAASParam param);

    /**
     * 发起任意交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/create_transaction")
    Call<ResultData<CreateSettlementTxRes>> createWaasTransaction(@Body  WalletTransactionSendDataWAASParam param);


    /**
     * 按已知的规范签名消息（EIP-191、 EIP-712）
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/web3/sign_message")
    Call<ResultData<SignatureWAASResult>> web3SignMessage(@Body signMessageParam param);

}
