package org.nhex.sinohope.sign;

import com.alibaba.fastjson2.JSON;
import org.nhex.sinohope.api.sign.ECDSA;
import org.nhex.sinohope.pojo.SettlementDetailDTO;
import org.nhex.sinohope.pojo.SettlementFinishDetailDTO;
import org.nhex.sinohope.pojo.SettlementFinishDTO;
import org.nhex.sinohope.pojo.SettlementDTO;

import java.util.Arrays;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;
import static org.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class ApplicationEcdsaExample {

    //this demo always use the latest sdk code
    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //初始化公私钥
        String publicKey ="3059301306072a8648ce3d020106082a8648ce3d030107034200040d40ecc03b81c3570d9252da05d4a2283b300da77505b61359e932c97c58c48af9ab7d3926abd40338a245360e8d91d989c451d046d46016b9d32ad70a0a9055";
        String privateKey ="308193020100301306072a8648ce3d020106082a8648ce3d030107047930770201010420093bf9385f3d2142f3a3f8101c23847f6de06fe89606a26d3b0d112428839586a00a06082a8648ce3d030107a144034200040d40ecc03b81c3570d9252da05d4a2283b300da77505b61359e932c97c58c48af9ab7d3926abd40338a245360e8d91d989c451d046d46016b9d32ad70a0a9055";

        //POST demo data1
        SettlementDTO settlementDTO = SettlementDTO.builder()
                .to_exchange(Arrays.asList(
                        SettlementDetailDTO.builder()
                                .amount("1")
                                .assetId("USDT_ETH_TEST")
                                .toAddress("0x5fcc1ab7271a14d3660f6dcabb038c11f97c4bf9")
                                .toTag("")
                                .build(),
                        SettlementDetailDTO.builder()
                                .amount("1")
                                .assetId("USDT_BNB")
                                .toAddress("0x5fcc1ab7271a14d3660f6dcabb038c11f97c4bf9")
                                .toTag("")
                                .build()
                ))
                .to_collateral(Arrays.asList(
                        SettlementDetailDTO.builder()
                                .amount("1")
                                .assetId("USDT_ETH_TEST")
                                .toAddress("192546320129407d0fbe2bbc2c54c1f394866046")
                                .toTag("")
                                .build(),
                        SettlementDetailDTO.builder()
                                .amount("1")
                                .assetId("USDT_BNB")
                                .toAddress("192546320129407d0fbe2bbc2c54c1f394866046")
                                .toTag("")
                                .build()
                ))
                .settlementId_ex("1688038913783")
                .collateralId("433366151883589")
                .build();

        //POST demo data2
        SettlementFinishDTO settlementFinishDTO = SettlementFinishDTO.builder()
                .settlementId("434094777691909")
                .cvaId("433366151883589")
                .data(Arrays.asList(
                        SettlementFinishDetailDTO.builder()
                                .assetId("USDT_BNB_TEST")
                                .status("COMPLETED")
                                .txHash("0xaacfdfc5cd215eb35f5a3a966dda3ac8ee765ccc7070459c4c4951dc3f715d19")
                                .build()
                )).build();

        //组装待签名数据
        //post1
        String[] msg1 = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/test/json", JSON.toJSONString(settlementDTO));
        System.out.println("demo1 signature data is ->" + msg1[0]);
        System.out.println("demo1 request nonce is ->" + msg1[1]);

        //签名
        String signature1 = ecdsa.sign(msg1[0], ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("demo1 signature is ->" + signature1);

        //验签
        System.out.println("demo1 Verify signature " + ecdsa.verify(msg1[0],
            ecdsa.parseX509PublicKey(publicKey),
            signature1));


        //post2
        String[] msg2 = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/test/json2", JSON.toJSONString(settlementFinishDTO));


        //get
        //String[] msg = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/order/findById",doBuildSignQueryString(paramMap));

        System.out.println("demo2 signature data is ->" + msg2[0]);
        System.out.println("demo2 request nonce is ->" + msg2[1]);

        //签名
        String signature2 = ecdsa.sign(msg2[0], ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("demo2 signature is ->" + signature2);

        //验签
        System.out.println("demo2 Verify signature " + ecdsa.verify(msg2[0],
                ecdsa.parseX509PublicKey(publicKey),
            signature2));
    }
}
