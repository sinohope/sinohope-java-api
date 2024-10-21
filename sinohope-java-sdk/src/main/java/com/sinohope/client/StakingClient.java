package com.sinohope.client;

import com.sinohope.request.StakingCreateTransferReq;
import com.sinohope.request.StakingDelegationReq;
import com.sinohope.request.StakingSpendingTimeLockPathTxReq;
import com.sinohope.request.StakingUnbondTransferReq;
import com.sinohope.response.BabylonDelegationRes;
import com.sinohope.response.common.ResultData;

import java.util.Map;

public interface StakingClient {
    ResultData<Map<String, Object>> create( StakingCreateTransferReq req);

    ResultData<Map<String, Object>> spendingTimeLockPathTx( StakingSpendingTimeLockPathTxReq req);


    ResultData<Map<String, Object>> unbond(StakingUnbondTransferReq req);

    ResultData<BabylonDelegationRes> delegation(StakingDelegationReq req);
}
