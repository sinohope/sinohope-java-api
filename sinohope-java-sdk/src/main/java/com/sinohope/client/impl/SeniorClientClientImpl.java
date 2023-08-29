package com.sinohope.client.impl;

import com.sinohope.client.SeniorClient;
import com.sinohope.request.WaasAddressPathParam;
import com.sinohope.request.WaasSignRawDataParam;
import com.sinohope.request.WaasUpdateWalletParam;
import com.sinohope.response.WaasAddressInfo;
import com.sinohope.response.WaasSignRawDataDTO;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.SeniorService;
import com.sinohope.sign.ECDSA;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

/**
 * @Author sunlf
 * @Date 2023/8/15
 */
public class SeniorClientClientImpl implements SeniorClient {
    private final SeniorService seniorService;

    public SeniorClientClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
        seniorService = createService(SeniorService.class, signer, env, publicKey, privateKey);
    }


    @Override
    public ResultData<WaasAddressInfo> genAddressByPath(WaasAddressPathParam param) {
        return executeSync(seniorService.genAddressByPath(param));
    }

    @Override
    public ResultData<WaasSignRawDataDTO> signRawData(WaasSignRawDataParam param) {
        return executeSync(seniorService.signRawData(param));

    }

    @Override
    public ResultData<Boolean> updateWallet(WaasUpdateWalletParam param) {
        return executeSync(seniorService.updateWallet(param));

    }
}
