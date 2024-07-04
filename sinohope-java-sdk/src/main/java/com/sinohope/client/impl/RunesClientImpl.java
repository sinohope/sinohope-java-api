package com.sinohope.client.impl;

import com.sinohope.client.Brc20Client;
import com.sinohope.client.RunesClient;
import com.sinohope.request.RunesBalanceReq;
import com.sinohope.request.RunesCreateTransferReq;
import com.sinohope.request.RunesPageBalanceSummaryReq;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.Brc20Service;
import com.sinohope.service.RunesService;
import com.sinohope.sign.ECDSA;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

public class RunesClientImpl implements RunesClient {

    private RunesService runesService;
    public RunesClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
        runesService = createService(RunesService.class, signer, env, publicKey, privateKey);
    }

    @Override
    public ResultData transfer(RunesCreateTransferReq param) {
        return executeSync(runesService.transfer(param));
    }

    @Override
    public ResultData pageBalanceSummary(RunesPageBalanceSummaryReq param) {
        return executeSync(runesService.pageBalanceSummary(param));
    }

    @Override
    public ResultData queryBalance(RunesBalanceReq param) {
        return executeSync(runesService.queryBalance(param));
    }
}
