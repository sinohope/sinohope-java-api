package org.nhex.sinohope.sign;

import com.nhex.sinohope.api.sign.DigitalSigner;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;

/**
 * org.nhex.sinohope.sign.DigitalSignerExample
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
@Deprecated
public class DigitalSignerExample {

    public static void main(String[] args) {
        //公钥
        byte[] publicKey;
        //私钥
        byte[] privateKey;

        //初始化密钥
        //生成密钥对
        Map<String, Object> keyMap = DigitalSigner.initKey();
        publicKey = DigitalSigner.getPublicKey(keyMap);
        privateKey = DigitalSigner.getPrivateKey(keyMap);
        System.out.println("ECDSA公钥:\n" + Base64.encodeBase64String(publicKey));
        System.out.println("ECDSA私钥:\n" + Base64.encodeBase64String(privateKey));

        System.out.println();
        String originalData = "{\n" +
                "  \"appKey\": \"def789\",\n" +
                "  \"appSecret\": \"uvw987\",\n" +
                "  \"operation\": \"update\",\n" +
                "  \"enabled\": false\n" +
                "}";
        //执行数字签名【私钥签名】
        byte[] digitalSign = DigitalSigner.digitalSign(originalData.getBytes(), privateKey);
        System.out.println("JDK ECDSA签名：:\n" + Base64.encodeBase64String(digitalSign));
        //验证签名【公钥验证】
        boolean bool = DigitalSigner.signVerify(originalData.getBytes(), digitalSign, publicKey);
        System.out.println("数字签名验签结果:\n" + bool);
    }
}
