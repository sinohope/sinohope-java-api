package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StakingService {

    /**
     * 创建staking交易
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/staking/create")
    Call<ResultData> create(@Body StakingCreateTransferReq param);

    /**
     * 到期提取交易
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/staking/spending_time_lock_path_tx")
    Call<ResultData> spendingTimeLockPathTx(@Body StakingSpendingTimeLockPathTxReq param);

    /**
     * 提前解除质押
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/staking/unbond")
    Call<ResultData> unbond(@Body StakingUnbondTransferReq param);

    /**
     * delegation
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/staking/delegation")
    Call<ResultData> delegation(@Body StakingDelegationReq param);
}
