package com.sinohope.client;

import com.sinohope.request.*;
import com.sinohope.response.*;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;

/**
 * brc20相关接口
 */
public interface Brc20Client {
    /**
     * brc20铭文铭刻-deploy
     * @param param
     * @return
     */
    ResultData inscribeDeploy(WaasBrc20InscribeDeployParam param);

    /**
     * brc20铭文铭刻-mint
     * @param param
     * @return
     */
    ResultData inscribeMint(WaasBrc20InscribeMintParam param);


    /**
     * brc20铭文铭刻-transfer
     * @param param
     * @return
     */
    ResultData inscribeTransfer(WaasBrc20InscribeTransferParam param);


    /**
     * brc20 transfer with id：brc20 转账
     * @param param
     * @return
     */
    ResultData inscribeTransferById(WaasBrc20InscribeTransferByIdParam param);


    /**
     * brc20 one-stop transfer:组合 inscribe transfer 和 transfer with id
     * @param param
     * @return
     */
    ResultData oneStopTransfer(WaasBrc20InscribeOneStopTransferParam param);


    /**
     * 查询指定地址的指定资产的BRC20可转铭文信息
     */
    ResultData<WaasBrc20QueryInscribeTransfersRes> queryInscribeTransfers(WaasBrc20QueryInscribeTransferReq param);

    /**
     * 查询指定地址的所有BRC20 资产余额信息 （分页查询）
     */
    ResultData<WaasBrc20PageQueryBalanceSummaryRes> queryPageBalanceSummary(WaasBrc20PageQueryBalanceSummaryReq param);

    /**
     * 查询指定地址的指定名称的BRC20 资产信息
     */
    ResultData<WaasBrc20QueryAddressTickerInfoRes> addressTickerInfo(WaasBrc20QueryAddressTickerInfoReq param);


    /**
     * 查询指定地址的指定名称的BRC20 资产信息
     */
    ResultData<WaasBrc20QueryAddressBalanceRes> addressBalance(WaasBrc20QueryAddressBalanceReq param);





}
