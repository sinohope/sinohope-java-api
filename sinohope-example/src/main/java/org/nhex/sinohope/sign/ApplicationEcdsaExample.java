package main.java.org.nhex.sinohope.sign;

import com.nhex.sinohope.api.sign.ECDSA;
import org.bouncycastle.util.encoders.Hex;

import java.security.KeyPair;

import static com.nhex.sinohope.api.sign.ECDSA.SECP256R1;
import static com.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class ApplicationEcdsaExample {

    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //初始化公私钥
        String publicKey ="3059301306072a8648ce3d020106082a8648ce3d0301070342000403330fbd2679e25b60f4a8ba43238bfae4637f27c3bcb2070873a62ef31310ae1a9a4b020633c785979d9963995cef3ff6d992ad2354bb2b0cf8b368b9371e6b";
        String privateKey ="308193020100301306072a8648ce3d020106082a8648ce3d03010704793077020101042039a8110eb9ce95470a59682716bee1de0e1578a9028eeded5ed3f2795a99f456a00a06082a8648ce3d030107a1440342000403330fbd2679e25b60f4a8ba43238bfae4637f27c3bcb2070873a62ef31310ae1a9a4b020633c785979d9963995cef3ff6d992ad2354bb2b0cf8b368b9371e6b";

        //数据加密
        String msg = doGenerateSignMetaDataAsString(publicKey, "/gaia-internal-api/demo/save");
        System.out.println("msg is ->" +msg);

        //签名
        String signature = ecdsa.sign(msg, ecdsa.parsePKCS8PrivateKey(privateKey));
        System.out.println("signature is ->" + signature);

        //验签
        System.out.println("Verify signature " + ecdsa.verify("path/gaia-internal-api/demo/savetimestamp1685607698975version1.0.03059301306072a8648ce3d020106082a8648ce3d0301070342000403330fbd2679e25b60f4a8ba43238bfae4637f27c3bcb2070873a62ef31310ae1a9a4b020633c785979d9963995cef3ff6d992ad2354bb2b0cf8b368b9371e6b",
                ecdsa.parseX509PublicKey(publicKey),
                "3045022066ed9c355010afd381a823bb47610d5b363120487a89773c701b3bfdf679e3780221008927cc57163ad42ac18573231725ba216cb75fd25a181b024ad155bc4ca87ebb"));
    }
}
