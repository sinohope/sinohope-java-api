package org.nhex.sinohope.sign;

import org.nhex.sinohope.api.sign.ECDSA;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;
import static org.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class ApplicationEcdsaExample {

    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //初始化公私钥
        String publicKey ="3059301306072a8648ce3d020106082a8648ce3d030107034200040d40ecc03b81c3570d9252da05d4a2283b300da77505b61359e932c97c58c48af9ab7d3926abd40338a245360e8d91d989c451d046d46016b9d32ad70a0a9055";
        String privateKey ="308193020100301306072a8648ce3d020106082a8648ce3d030107047930770201010420093bf9385f3d2142f3a3f8101c23847f6de06fe89606a26d3b0d112428839586a00a06082a8648ce3d030107a144034200040d40ecc03b81c3570d9252da05d4a2283b300da77505b61359e932c97c58c48af9ab7d3926abd40338a245360e8d91d989c451d046d46016b9d32ad70a0a9055";

        //数据加密
        String msg = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/save");
        System.out.println("msg is ->" +msg);

        //签名
        String signature = ecdsa.sign(msg, ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("signature is ->" + signature);

        //验签
        System.out.println("Verify signature " + ecdsa.verify(msg,
                ecdsa.parseX509PublicKey(publicKey),
                signature));
    }
}
