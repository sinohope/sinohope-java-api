package com.sinohope.request;

import lombok.Data;


/**
 * @author yanghaiyu
 * @date 2023/07/26
 **/
@Data
public class WaasMpcNodeExecRecordParam {
    /**
     * 业务执行类型（KeyGen 类型请求：1，signTx 类型请求：2，signMessage 类型请求：3，signRawData 类型请求：4）
     */
    private Integer businessExecType;
    /**
     * 业务执行状态 (进行中：0，成功：1，失败：2）
     */
    private Integer businessExecStatus;
    /**
     * sinoId,不传按照分页查询
     */
    private String sinoId;

    /**
     * 当前页码，首页为1,默认1
     */
    private Integer pageIndex = 1;

    /***
     * 每页数据条数（不得小于1,不得大于50）
     */
    private Integer pageSize = 50;
}
