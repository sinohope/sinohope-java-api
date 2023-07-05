package org.nhex.sinohope.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author lishuo
 * @Date 2023-07-04 18:31
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettlementReqDemo {
    private List<SettlementDetailDTO> to_exchange;
    private List<SettlementDetailDTO> to_collateral;
    private String settlementId_ex;
    private String collateralId;

    //example json
    /*{
        "collateralId":"433366151883589",
            "settlementId_ex":"1688038913783",
            "to_collateral": [
        {
            "amount":"1",
                "assetId":"USDT_ETH_TEST",
                "toAddress":"192546320129407d0fbe2bbc2c54c1f394866046",
                "toTag":""
        },
        {
            "amount":"1",
                "assetId":"USDT_BNB",
                "toAddress":"192546320129407d0fbe2bbc2c54c1f394866046",
                "toTag":""
        }
    ],
        "to_exchange": [
        {
            "amount":"1",
                "assetId":"USDT_ETH_TEST",
                "toAddress":"0x5fcc1ab7271a14d3660f6dcabb038c11f97c4bf9",
                "toTag":""
        },
        {
            "amount":"1",
                "assetId":"USDT_BNB",
                "toAddress":"0x5fcc1ab7271a14d3660f6dcabb038c11f97c4bf9",
                "toTag":""
        }
    ]
    }*/
}
