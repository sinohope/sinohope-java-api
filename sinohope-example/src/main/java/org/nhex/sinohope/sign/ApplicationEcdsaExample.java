package org.nhex.sinohope.sign;

import api.sign.ECDSA;

import static api.sign.ECDSA.SECP256R1;
import static api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class ApplicationEcdsaExample {

    public static void main(String[] args) throws Exception {
        ECDSA ecdsa = new ECDSA(SECP256R1);

        //初始化公私钥
        String publicKey ="3059301306072a8648ce3d020106082a8648ce3d030107034200040f1654247a9efa8aa2595d5b0c58c057cac6f7325a65e7d07fa64cb7d9bec22983b7ca9b50e4d7cf4fa541bc818fd0431ffc4cd8d65938bfde034e8569cdbc21";
        String privateKey ="308193020100301306072a8648ce3d020106082a8648ce3d0301070479307702010104204ede498af6c0b1d14500c50d3b5ff293196487256ac25b097b9524714d9aee65a00a06082a8648ce3d030107a144034200040f1654247a9efa8aa2595d5b0c58c057cac6f7325a65e7d07fa64cb7d9bec22983b7ca9b50e4d7cf4fa541bc818fd0431ffc4cd8d65938bfde034e8569cdbc21";

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
