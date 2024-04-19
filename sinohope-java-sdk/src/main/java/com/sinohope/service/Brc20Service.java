package com.sinohope.service;

import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Brc20Service {


    /**
     * brc20铭文铭刻-deploy
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/brc20/inscribe_deploy")
    Call<ResultData> inscribeDeploy(@Body WaasBrc20InscribeDeployParam param);

    /**
     * brc20铭文铭刻-mint
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/brc20/inscribe_mint")
    Call<ResultData> inscribeMint(@Body WaasBrc20InscribeMintParam param);


    /**
     * brc20铭文铭刻-transfer
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/brc20/inscribe_transfer")
    Call<ResultData> inscribeTransfer(@Body WaasBrc20InscribeTransferParam param);


    /**
     * brc20 transfer with id：brc20 转账
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/brc20/inscribe_transfer_by_id")
    Call<ResultData> inscribeTransferById(@Body WaasBrc20InscribeTransferByIdParam param);


    /**
     * brc20 one-stop transfer:组合 inscribe transfer 和 transfer with id
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/brc20/one_stop_transfer")
    Call<ResultData> oneStopTransfer(@Body WaasBrc20InscribeOneStopTransferParam param);


    /**
     * 查询指定地址的指定资产的BRC20可转铭文信息
     */
    @POST("/v1/waas/mpc/brc20/query_inscribe_transfers")
    Call<ResultData<WaasBrc20QueryInscribeTransfersRes>> queryInscribeTransfers(@Body WaasBrc20QueryInscribeTransferReq param);

    /**
     * 查询指定地址的所有BRC20 资产余额信息 （分页查询）
     */
    @POST("/v1/waas/mpc/brc20/page_balance_summary")
    Call<ResultData<WaasBrc20PageQueryBalanceSummaryRes>> queryPageBalanceSummary(@Body WaasBrc20PageQueryBalanceSummaryReq param);

    /**
     * 查询指定地址的指定名称的BRC20 资产信息
     */
    @POST("/v1/waas/mpc/brc20/address_ticker_info")
    Call<ResultData<WaasBrc20QueryAddressTickerInfoRes>> addressTickerInfo(@Body WaasBrc20QueryAddressTickerInfoReq param);

    /**
     * 查询指定地址的指定名称的BRC20 资产信息
     */
    @POST("/v1/waas/mpc/brc20/address_balance")
     Call<ResultData<WaasBrc20QueryAddressBalanceRes>> addressBalance(@Body WaasBrc20QueryAddressBalanceReq param);
}
