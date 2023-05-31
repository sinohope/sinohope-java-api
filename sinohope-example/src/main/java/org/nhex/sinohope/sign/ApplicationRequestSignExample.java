package org.nhex.sinohope.sign;

import com.nhex.sinohope.api.sign.DigitalSigner;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;

import static com.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaData;

/**
 * @Title: ApplicationRequestSignExample
 * @Author lishuo
 * @Date 2023-05-31 15:23
 **/
public class ApplicationRequestSignExample {


    public static void main(String[] args) {
        //传入公钥、请求接口路径参数
        byte[] originalData = doGenerateSignMetaData("MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCCbE7rOXSsAXYN3ik5+RdCKfp9mCgPNTVep3kBFQSByrw==",
                "/projectName/demo/save");

        //执行数字签名【私钥签名】Base64.decodeBase64(私钥)
        byte[] digitalSign = DigitalSigner.digitalSign(originalData, Base64.decodeBase64("MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCCbE7rOXSsAXYN3ik5+RdCKfp9mCgPNTVep3kBFQSByrw=="));
        System.out.println("JDK ECDSA签名：:\n" + Base64.encodeBase64String(digitalSign));

        System.out.println();

        //验证签名【公钥验证】Base64.decodeBase64(公钥)
        boolean bool = DigitalSigner.signVerify(originalData, digitalSign, Base64.decodeBase64("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEasYYH8f59PgKqZDLUsOQugSS7nVIW6rkB9i986xqIQ1Uh8qMkVpCSXZkP35TJcAFu+P43aIIee2i0iwt1X8exA=="));
        System.out.println("数字签名验签结果:\n" + bool);
    }

}
