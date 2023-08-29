package com.sinohope.service;

import com.sinohope.request.WaasAddressPathParam;
import com.sinohope.request.WaasSignRawDataParam;
import com.sinohope.request.WaasUpdateWalletParam;
import com.sinohope.response.WaasAddressInfo;
import com.sinohope.response.WaasSignRawDataDTO;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author sunlf
 * @Date 2023/8/15
 */
public interface SeniorService {
    /**
     * 原始数据签名
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/wallet/advance/sign_raw_data")
    Call<ResultData<WaasSignRawDataDTO>> signRawData(@Body WaasSignRawDataParam param);



    /**
     * 根据指定的路径创建地址
     * <p> 直接对指定数据进行签名。此接口为高级功能接口，需要钱包组 以及 钱包 均开启“高级功能” 才可用 </>
     * @param
     */
    @POST("/v1/waas/mpc/wallet/advance/gen_address_by_path")
    Call<ResultData<WaasAddressInfo>> genAddressByPath(@Body WaasAddressPathParam param);


    /**
     * 更新钱包属性（高级功能开启、关闭
     */
    @POST("/v1/waas/mpc/wallet/advance/update_wallet")
    Call<ResultData<Boolean>> updateWallet(@Body WaasUpdateWalletParam param);

}
