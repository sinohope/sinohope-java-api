package org.nhex.sinohope.sign;

import api.sign.DigitalSigner;
import org.apache.commons.codec.binary.Base64;

/**
 * @Title: ApplicationRequestSignExample
 * @Author lishuo
 * @Date 2023-05-31 15:23
 **/
@Deprecated
public class ApplicationRequestSignExample {


  public static void main(String[] args) {

    String publicKey = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEFJG6YdAsBdwmWuSYX3lMHL+LYpGrddVO8dY/uhfbnj3kUDEo6QKJH8kxNzuCXyBtfvjoM/cKLZBafi3CCIZH4g==";
    String privKey = "MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCCVRpXaeehHHaKbIq9EGUMgWQX6z8vASRqLczBckMArNg==";
    //传入公钥、请求接口路径参数
//        byte[] originalData = doGenerateSignMetaData(publicKey,
//                "/gaia-internal-api/demo/save");
//        System.out.println("originalData：:\n" + Base64.encodeBase64String(originalData));
//
//        //执行数字签名【私钥签名】Base64.decodeBase64(私钥)
//        byte[] digitalSign = DigitalSigner.digitalSign(originalData, Base64.decodeBase64(privKey));
//        System.out.println("JDK ECDSA签名：:\n" + Base64.encodeBase64String(digitalSign));
//        System.out.println("JDK ECDSA签名byte：:\n" + Arrays.toString(digitalSign));

    System.out.println();

    //验证签名【公钥验证】Base64.decodeBase64(公钥)
    boolean bool = DigitalSigner.signVerify("cGF0aC9nYWlhLWludGVybmFsLWFwaS9kZW1vL3NhdmV0aW1lc3RhbXAxNjg1NjA1OTUzNzk5dmVyc2lvbjEuMC4wTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFRkpHNllkQXNCZHdtV3VTWVgzbE1ITCtMWXBHcmRkVk84ZFkvdWhmYm5qM2tVREVvNlFLSkg4a3hOenVDWHlCdGZ2am9NL2NLTFpCYWZpM0NDSVpINGc9PQ==\n".getBytes(),
        "MEUCIBBb/pvfAaOs4+mhUbnaYfctLztW6BC+fFml6hUAc7nZAiEA/FqBo7RXn5V/Drj1J72DzC5tivzDQcmqnMp+tp4opFQ=".getBytes(),
        Base64.decodeBase64(publicKey));
    System.out.println("数字签名验签结果:\n" + bool);
  }

}
