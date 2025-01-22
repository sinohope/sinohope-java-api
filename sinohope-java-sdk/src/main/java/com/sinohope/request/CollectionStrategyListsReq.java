package com.sinohope.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class CollectionStrategyListsReq extends BaseWaasParam{
    @JsonSerialize(using = ToStringSerializer.class)
    private Long vaultId;
}
