package org.nhex.sinohope.sign;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nhex.sinohope.api.sign.ECDSA;
import org.bouncycastle.util.encoders.Hex;

import java.security.KeyPair;
import java.util.Map;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;
import static org.nhex.sinohope.api.util.SignerUtil.convertJsonToQueryString;
import static org.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
@Deprecated
public class EcdsaExample {

    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //取公私钥
        KeyPair pair = ecdsa.generateKeyPair();
        String privateKey = Hex.toHexString(pair.getPrivate().getEncoded());
        String publicKey = Hex.toHexString(pair.getPublic().getEncoded());
        System.out.println("publicKey is ->" + publicKey);
        System.out.println("privateKey is ->" + privateKey);

        //替换请求的json数据
        String json = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": \"30\",\n" +
                "  \"city\": \"New York\",\n" +
                "  \"hobbies\": [\"reading\", \"playing-guitar\", \"painting\"]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);

            String dataString = "?" + convertJsonToQueryString(jsonMap); // 添加开头的问号
            dataString = dataString.replaceAll("&+$", ""); // 去掉末尾的多余的“&”

        //数据加密
        String[] msg = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/save",dataString);
        System.out.println("signature data is ->" + msg[0]);
        System.out.println("request nonce is ->" + msg[1]);

        //签名
        String signature = ecdsa.sign(msg[0], ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("signature is ->" + signature);

        //验签
        System.out.println("Verify signature " + ecdsa.verify(msg[0], ecdsa.parseX509PublicKey(publicKey), signature));
    }
}
