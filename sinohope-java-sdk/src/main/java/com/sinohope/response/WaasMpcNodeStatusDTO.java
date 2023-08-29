package com.sinohope.response;

import lombok.Data;


@Data
public class WaasMpcNodeStatusDTO {
    /**
     * 节点id
     */
    private String nodeId;
    /**
     * 在线状态 (offline：0，online：1)
     * <p> MpcNode 和 sinohope的连接状态</p>
     */
    private Integer onlineStatus;
}
