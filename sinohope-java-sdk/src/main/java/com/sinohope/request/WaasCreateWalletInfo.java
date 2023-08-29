package com.sinohope.request;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanghaiyu
 * @date 2023/07/19
 **/
@Data
@ToString
public class WaasCreateWalletInfo {
    /**
     * 钱包名称
     * 为空的话用默认值: wallet+随机值
     * 不为空时：部门下钱包名称不能给重复
     */
    private String walletName ;
    /**
     * 高级功能开关 (关：0，开：1)
     * <p> 开了以后支持的功能: 根据指定的路径创建地址 ,原始数据签名 <p/>
     */
    private Integer advancedEnabled = 0;


}
