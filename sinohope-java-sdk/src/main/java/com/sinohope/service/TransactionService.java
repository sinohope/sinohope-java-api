package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.FeeDTO;
import com.sinohope.response.SignResultDTO;
import com.sinohope.response.WaasTransactionDTO;
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
    Call<ResultData<PageData<WaasTransactionDTO>>> walletTransactionList(@Body WalletTransactionQueryWAASParam param);


    /**
     * 根据requestIds查询交易列表
     *
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_request_ids")
    Call<ResultData<PageData<WaasTransactionDTO>>> walletTransactionListByRequestId(@Body WalletTransactionQueryWAASRequestIdParam param);


    /**
     * 根据sinoIds查询交易列表
     *
     * @param sinoIds
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_sino_ids")
    Call<ResultData<PageData<WaasTransactionDTO>>> walletTransactionListByTransactionId(@Body WalletTransactionQueryWAASSinoIdParam sinoIds);

    /**
     * 根据txHash查询交易列表
     *
     * @param txHash
     * @return
     */
    @POST("/v1/waas/mpc/transaction/transactions_by_tx_hash")
    Call<ResultData<PageData<WaasTransactionDTO>>> walletTransactionListByTxHash(@Body WalletTransactionQueryWAASTxHashdParam txHash);
    /**
     * 根据txHash查询交易列表
     *
     * @param txHash
     * @return
     */
    @POST("/v1/waas/mpc/transaction/page_available_vouts")
    Call<ResultData<PageData<VinDTO>>> pageAvailableVouts(@Body WaasPageUtxoReq txHash);

    /**
     * 发起转账交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/create_transfer")
    Call<ResultData<WaasTransactionDTO>> createWaasTransfer(@Body WalletTransactionSendWAASParam param);

    /**
     * 发起加速交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/speedup_transaction")
    Call<ResultData<WaasTransactionDTO>> speedupWaasTransfer(@Body  WalletTransactionSpeedupWAASParam param);


    /**
     * 交易取消
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/cancel_transaction")
    Call<ResultData<WaasTransactionDTO>> waasCancelTransaction(@Body WalletTransactionCancelWAASParam param);

    /**
     * 发起任意交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/create_transaction")
    Call<ResultData<WaasTransactionDTO>> createWaasTransaction(@Body  WalletTransactionSendDataWAASParam param);


    /**
     * 按已知的规范签名消息（EIP-191、 EIP-712）
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/web3/sign_message")
    Call<ResultData<SignatureWAASResult>> web3SignMessage(@Body signMessageParam param);

    /**
     * 查询交易所需交易费用
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/transaction/fee")
    Call<ResultData<FeeDTO>> transactionFee(@Body TransactionFeeParam param);

    /**
     * 查询签名结果
     *
     * @param param
     * @return
     * @throws Exception
     */
    @POST("/v1/waas/mpc/web3/sign_result")
    Call<ResultData<SignResultDTO>> signResult(@Body SignResultParam param);

}
