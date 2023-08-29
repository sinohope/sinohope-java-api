package com.sinohope.client;

import com.sinohope.request.WaasAddressPathParam;
import com.sinohope.request.WaasSignRawDataParam;
import com.sinohope.request.WaasUpdateWalletParam;
import com.sinohope.response.WaasAddressInfo;
import com.sinohope.response.WaasSignRawDataDTO;
import com.sinohope.response.common.ResultData;

/**
 * 高级功能接口
 *
 * @Author sunlf
 * @Date 2023/8/15
 */
public interface SeniorClient {
    ResultData<WaasAddressInfo> genAddressByPath(WaasAddressPathParam param);


    /**
     * 原始数据签名
     * <p>对原始数据进行签名</>
     * @param
     */
    ResultData<WaasSignRawDataDTO> signRawData( WaasSignRawDataParam param);


    ResultData<Boolean> updateWallet( WaasUpdateWalletParam param);

}
