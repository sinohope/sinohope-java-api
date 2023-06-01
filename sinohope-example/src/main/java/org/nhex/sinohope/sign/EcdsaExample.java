package org.nhex.sinohope.sign;

import com.nhex.sinohope.api.sign.ECDSA;
import org.bouncycastle.util.encoders.Hex;

import java.security.KeyPair;

import static com.nhex.sinohope.api.sign.ECDSA.SECP256R1;
import static com.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaData;
import static com.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class EcdsaExample {

    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //取公私钥
        KeyPair pair = ecdsa.generateKeyPair();
        String privateKey = Hex.toHexString(pair.getPrivate().getEncoded());
        String publicKey = Hex.toHexString(pair.getPublic().getEncoded());
        System.out.println("publicKey is ->" +publicKey);
        System.out.println("privateKey is ->" +privateKey);

        //数据加密
        String msg = doGenerateSignMetaDataAsString(publicKey,"/gaia-internal-api/demo/save");

        //签名
        String signature = ecdsa.sign(msg, ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("signature is ->" +signature);

        //验签
        System.out.println("Verify signature " + ecdsa.verify(msg, ecdsa.parseX509PublicKey(publicKey), signature));
    }
}
