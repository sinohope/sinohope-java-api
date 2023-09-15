package com.sinohope.client;

import com.sinohope.request.SignatureWAASResult;
import com.sinohope.response.WaasTransactionDTO;
import com.sinohope.request.WalletTransactionCancelWAASParam;
import com.sinohope.request.WalletTransactionQueryWAASParam;
import com.sinohope.request.WalletTransactionQueryWAASRequestIdParam;
import com.sinohope.request.WalletTransactionQueryWAASSinoIdParam;
import com.sinohope.request.WalletTransactionQueryWAASTxHashdParam;
import com.sinohope.request.WalletTransactionSendDataWAASParam;
import com.sinohope.request.WalletTransactionSendWAASParam;
import com.sinohope.request.WalletTransactionSpeedupWAASParam;
import com.sinohope.request.signMessageParam;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;

import java.util.List;

/**
 * 交易相关接口
 *
 * @Author sunlf
 * @Date 2023/8/15
 */
public interface TransactionClient {

    /**
     * 交易列表，查询充值提现所有的交易记录
     *
     * @param param
     * @return
     */
    ResultData<PageData<WaasTransactionDTO>> walletTransactionList(WalletTransactionQueryWAASParam param);


    /**
     * 根据requestIds查询交易列表
     *
     * @param param
     * @return
     */
    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByRequestId(WalletTransactionQueryWAASRequestIdParam param);


    /**
     * 根据sinoIds查询交易列表
     *
     * @param sinoIds
     * @return
     */
    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTransactionId(WalletTransactionQueryWAASSinoIdParam sinoIds);

    /**
     * 根据txHash查询交易列表
     *
     * @param txHash
     * @return
     */
    ResultData<PageData<WaasTransactionDTO>> walletTransactionListByTxHash(WalletTransactionQueryWAASTxHashdParam txHash);

    /**
     * 发起转账交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    ResultData<WaasTransactionDTO> createWaasTransfer(WalletTransactionSendWAASParam param);

    /**
     * 发起加速交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    ResultData<WaasTransactionDTO> speedupWaasTransfer(WalletTransactionSpeedupWAASParam param);


    /**
     * 交易取消
     *
     * @param param
     * @return
     * @throws Exception
     */
    ResultData<WaasTransactionDTO> waasCancelTransaction(WalletTransactionCancelWAASParam param);

    /**
     * 发起任意交易
     *
     * @param param
     * @return
     * @throws Exception
     */
    ResultData<WaasTransactionDTO> createWaasTransaction(WalletTransactionSendDataWAASParam param);


    /**
     * 按已知的规范签名消息（EIP-191、 EIP-712）
     *
     * @param param
     * @return
     * @throws Exception
     */
    ResultData<SignatureWAASResult> web3SignMessage(signMessageParam param);

}
