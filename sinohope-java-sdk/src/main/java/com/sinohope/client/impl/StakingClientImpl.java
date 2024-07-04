package com.sinohope.client.impl;

import com.sinohope.client.StakingClient;
import com.sinohope.request.StakingCreateTransferReq;
import com.sinohope.request.StakingDelegationReq;
import com.sinohope.request.StakingSpendingTimeLockPathTxReq;
import com.sinohope.request.StakingUnbondTransferReq;
import com.sinohope.response.BabylonDelegationRes;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.Brc20Service;
import com.sinohope.service.StakingService;
import com.sinohope.sign.ECDSA;

import java.util.Map;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

public class StakingClientImpl  implements StakingClient {


    private StakingService stakingService;
    public StakingClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
        stakingService = createService(StakingService.class, signer, env, publicKey, privateKey);
    }
    @Override
    public ResultData<Map<String, Object>> create(StakingCreateTransferReq req) {
        return executeSync(stakingService.create(req));
    }

    @Override
    public ResultData<Map<String, Object>> spendingTimeLockPathTx(StakingSpendingTimeLockPathTxReq req) {
        return executeSync(stakingService.spendingTimeLockPathTx(req));
    }

    @Override
    public ResultData<Map<String, Object>> unbond(StakingUnbondTransferReq req) {
        return executeSync(stakingService.unbond(req));
    }

    @Override
    public ResultData<BabylonDelegationRes> delegation(StakingDelegationReq req) {
        return executeSync(stakingService.delegation(req));
    }
}
