package com.sinohope.client;

import com.sinohope.request.WaasMpcNodeExecRecordParam;
import com.sinohope.response.WaasMpcNodeExecRecordDTO;
import com.sinohope.response.WaasMpcNodeStatusDTO;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;

/**
 * MpcNode 相关接口client
 *
 * @author wangfengchen
 */
public interface MpcNodeClient {


    ResultData<PageData<WaasMpcNodeExecRecordDTO>> listMpcRequests(WaasMpcNodeExecRecordParam param);


    ResultData<WaasMpcNodeStatusDTO> status();


}
