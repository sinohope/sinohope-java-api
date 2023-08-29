package com.sinohope.response;

import lombok.Data;

@Data
public class WaasTransferAddressSwitchDTO {
    /**
     * 风控开关 (true 开启, false 关闭)
     */
    private Boolean riskControlEnabled;
}
