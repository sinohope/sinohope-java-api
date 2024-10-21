package com.sinohope.client.impl;

import com.sinohope.client.Brc20Client;
import com.sinohope.request.*;
import com.sinohope.response.WaasBrc20PageQueryBalanceSummaryRes;
import com.sinohope.response.WaasBrc20QueryAddressBalanceRes;
import com.sinohope.response.WaasBrc20QueryAddressTickerInfoRes;
import com.sinohope.response.WaasBrc20QueryInscribeTransfersRes;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.Brc20Service;
import com.sinohope.service.MpcNodeService;
import com.sinohope.service.TransactionService;
import com.sinohope.sign.ECDSA;
import retrofit2.Call;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

public class Brc20ClientImpl implements Brc20Client {

    private Brc20Service brc20Service;
    public Brc20ClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
        brc20Service = createService(Brc20Service.class, signer, env, publicKey, privateKey);
    }

    @Override
    public ResultData inscribeDeploy(WaasBrc20InscribeDeployParam param) {
        return executeSync(brc20Service.inscribeDeploy(param));
    }

    @Override
    public ResultData inscribeMint(WaasBrc20InscribeMintParam param) {
        return executeSync(brc20Service.inscribeMint(param));
    }

    @Override
    public ResultData inscribeTransfer(WaasBrc20InscribeTransferParam param) {
        return executeSync(brc20Service.inscribeTransfer(param));
    }

    @Override
    public ResultData inscribeTransferById(WaasBrc20InscribeTransferByIdParam param) {
        return executeSync(brc20Service.inscribeTransferById(param));
    }

    @Override
    public ResultData oneStopTransfer(WaasBrc20InscribeOneStopTransferParam param) {
        return executeSync(brc20Service.oneStopTransfer(param));
    }

    @Override
    public ResultData<WaasBrc20QueryInscribeTransfersRes> queryInscribeTransfers(WaasBrc20QueryInscribeTransferReq param) {
        return executeSync(brc20Service.queryInscribeTransfers(param));
    }

    @Override
    public ResultData<WaasBrc20PageQueryBalanceSummaryRes> queryPageBalanceSummary(WaasBrc20PageQueryBalanceSummaryReq param) {
        return executeSync(brc20Service.queryPageBalanceSummary(param));
    }

    @Override
    public ResultData<WaasBrc20QueryAddressTickerInfoRes> addressTickerInfo(WaasBrc20QueryAddressTickerInfoReq param) {
        Call<ResultData<WaasBrc20QueryAddressTickerInfoRes>> resultDataCall = brc20Service.addressTickerInfo(param);
        return executeSync(resultDataCall);
    }

    @Override
    public ResultData<WaasBrc20QueryAddressBalanceRes> addressBalance(WaasBrc20QueryAddressBalanceReq param) {
        return executeSync(brc20Service.addressBalance(param));
    }
}
