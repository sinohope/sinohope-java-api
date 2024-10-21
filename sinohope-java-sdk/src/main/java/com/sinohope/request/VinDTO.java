package com.sinohope.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class VinDTO implements Comparable<VinDTO> {

    private Long id;

    private Integer blockId;

    private String blockHash;

    private Integer blockState;

    private Long blockHeight;

    private String transactionHash;

    private Long voutIndex;

    private BigDecimal amount;

    private String assetChainName;

    private String address;

    private String tag;

    /**
     * 0: 未成熟, 1: 可花, 3: 未确认完成 1或2=3, |8: 表示被花且上链（9=1|8,11=3|8）
     */
    private Integer state;

    private String spentTransaction;

    private Integer spentVinIndex;

    private String currency;

    private Long blockTimeStamp;

    @Override
    public int compareTo(@NotNull VinDTO o) {
        if(this.getAmount().compareTo(o.getAmount()) > 0){
            return -1;
        }else if(this.getAmount().compareTo(o.getAmount()) < 0){
            return 1;
        }
        return 0;
    }
}
