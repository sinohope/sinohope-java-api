package com.sinohope.client;

import com.sinohope.request.*;
import com.sinohope.response.WaasBrc20PageQueryBalanceSummaryRes;
import com.sinohope.response.WaasBrc20QueryAddressBalanceRes;
import com.sinohope.response.WaasBrc20QueryAddressTickerInfoRes;
import com.sinohope.response.WaasBrc20QueryInscribeTransfersRes;
import com.sinohope.response.common.ResultData;

/**
 * brc20相关接口
 */
public interface RunesClient {
    /**
     * runes创建交易
     * @param param
     * @return
     */
    ResultData transfer(RunesCreateTransferReq param);

    /**
     * 查询接口-根据address查询rune资产列表和余额
     * @param param
     * @return
     */
    ResultData pageBalanceSummary(RunesPageBalanceSummaryReq param);


    /**
     * 查询接口-根据address和runeid查询余额
     * @param param
     * @return
     */
    ResultData queryBalance(RunesBalanceReq param);
}
