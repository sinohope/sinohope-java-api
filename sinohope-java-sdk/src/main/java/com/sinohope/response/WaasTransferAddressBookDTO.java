package com.sinohope.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WaasTransferAddressBookDTO {
    /**
     * 地址
     */
    private String address;
}
