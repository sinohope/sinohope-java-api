package com.sinohope.client.impl;

import com.sinohope.client.MpcNodeClient;
import com.sinohope.request.WaasMpcNodeExecRecordParam;
import com.sinohope.response.WaasMpcNodeExecRecordDTO;
import com.sinohope.response.WaasMpcNodeStatusDTO;
import com.sinohope.response.common.PageData;
import com.sinohope.response.common.ResultData;
import com.sinohope.service.MpcNodeService;
import com.sinohope.sign.ECDSA;

import static com.sinohope.service.ApiServiceGenerator.createService;
import static com.sinohope.service.ApiServiceGenerator.executeSync;

/**
 * @author wangfengchen
 */
public class MpcNodeClientImpl implements MpcNodeClient {

  private final MpcNodeService MpcNodeService;

  public MpcNodeClientImpl(ECDSA signer, String env, String publicKey, String privateKey) {
    MpcNodeService = createService(MpcNodeService.class, signer, env, publicKey, privateKey);
  }


  @Override
  public ResultData<PageData<WaasMpcNodeExecRecordDTO>> listMpcRequests(WaasMpcNodeExecRecordParam param) {
    return executeSync(MpcNodeService.listMpcRequests(param));
  }

  @Override
  public ResultData<WaasMpcNodeStatusDTO> status() {
    return executeSync(MpcNodeService.status());

  }
}
