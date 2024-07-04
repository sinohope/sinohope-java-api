package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RunesService {


    /**
     * runes创建交易
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/runes/transfer")
    Call<ResultData> transfer(@Body RunesCreateTransferReq param);

    /**
     * 查询接口-根据address查询rune资产列表和余额
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/runes/page_balance_summary")
    Call<ResultData> pageBalanceSummary(@Body RunesPageBalanceSummaryReq param);

    /**
     * 查询接口-根据address和runeid查询余额
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/runes/balance")
    Call<ResultData> queryBalance(@Body RunesBalanceReq param);
}
