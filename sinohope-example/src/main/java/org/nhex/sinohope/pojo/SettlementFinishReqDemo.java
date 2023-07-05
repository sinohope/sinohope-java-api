package org.nhex.sinohope.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author lishuo
 * @Date 2023-07-04 18:30
 **/
@Data
@Builder
public class SettlementFinishReqDemo {
    private String settlementId;
    private String cvaId;
    private List<SettlementFinishDetailReqDto> data;

    //example json
   /* {
        "settlementId":434094777691909,
            "cvaId":433366151883589,
            "data":[
        {
            "assetId":"USDT_BNB_TEST",
                "status":"COMPLETED",
                "txHash":"0xaacfdfc5cd215eb35f5a3a966dda3ac8ee765ccc7070459c4c4951dc3f715d19"
        }
    ]
    }*/
}


