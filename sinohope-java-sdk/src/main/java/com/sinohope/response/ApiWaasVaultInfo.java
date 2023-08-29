package com.sinohope.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiWaasVaultInfo implements Serializable {
    private Integer businessType;
    private List<VaultInfoOfOpenApi> vaultInfoOfOpenApiList;
    @Data
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VaultInfoOfOpenApi  implements Serializable{
        /**
         * 金库id
         */
        private String vaultId;
        /**
         * 金库名称
         */
        private String vaultName;
        /**
         * 创建时间
         */
        private String createTime;
        /**
         * 权限 查询 1、操作 2、提现 3、任意交易0
         */
        private String authorityType;
    }
}
