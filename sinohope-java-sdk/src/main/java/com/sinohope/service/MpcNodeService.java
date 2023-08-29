package com.sinohope.service;

import com.sinohope.request.WaasMpcNodeExecRecordParam;
import com.sinohope.response.WaasMpcNodeExecRecordDTO;
import com.sinohope.response.WaasMpcNodeStatusDTO;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author wangfengchen
 */
public interface MpcNodeService {

    /**
     * 查询mpc协议执行记录
     * @param param
     * @return
     */
    @POST("/v1/waas/mpc/mpcnode/list_mpc_requests")
    Call<ResultData<PageData<WaasMpcNodeExecRecordDTO>>> listMpcRequests(@Body WaasMpcNodeExecRecordParam param);

    /**
     * 查询tss node状态
     * @return
     */
    @POST("/v1/waas/mpc/mpcnode/status")
    Call<ResultData<WaasMpcNodeStatusDTO>> status();


}
