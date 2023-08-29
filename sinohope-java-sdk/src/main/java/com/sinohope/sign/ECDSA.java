package com.sinohope.sign;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.*;
/**
 * @Title:
 * @Author lishuo
 * @Date 2023-06-01 16:01
 **/
public class ECDSA {

        public static final String SECP256R1 = "secp256r1";
        public static final String SECP256K1 = "secp256k1";
        public static final String ALGO_EC = "EC";
        public static final String SHA256_ECDSA = "SHA256withECDSA";
        private static volatile ECDSA instance = null;

        public ECDSA getR1() {
            if (instance == null) {
                synchronized (ECDSA.class) {
                    if (instance == null) {
                        try {
                            instance = new ECDSA(SECP256R1);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            return instance;
        }

        private KeyFactory keyFactory = KeyFactory.getInstance(ALGO_EC, new BouncyCastleProvider());
        private Signature signer = Signature.getInstance(SHA256_ECDSA, new BouncyCastleProvider());
        private String algorithm;
        private ECNamedCurveSpec params;

        public ECDSA(String algorithm) throws Exception {
            ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec(algorithm);
            if (spec == null) {
                throw new Exception("Unknown algorithm: " + algorithm);
            }
            params = new ECNamedCurveSpec(algorithm, spec.getCurve(), spec.getG(), spec.getN());
            this.algorithm = algorithm;
        }

        public String sign(String msg, PrivateKey privateKey) throws Exception {
            signer.initSign(privateKey);
            signer.update(msg.getBytes(StandardCharsets.UTF_8));
            return Hex.toHexString(signer.sign());
        }

        public boolean verify(String msg, PublicKey publicKey, String signatureHex) throws Exception {
            signer.initVerify(publicKey);
            signer.update(msg.getBytes(StandardCharsets.UTF_8));
            return signer.verify(Hex.decode(signatureHex));
        }

        public boolean verifyIos(String sig, String body,String pub) throws Exception {
            return verify(body, parseECPublicKey(pub), sig);
        }

        public boolean verifyAndroid(String sig, String body,String pub) throws Exception {
            return verify(body, parseX509PublicKey(pub), sig);
        }

        public PublicKey parseX509PublicKey(String publicKeyHex) throws Exception {
            byte[] publicKey = Hex.decode(publicKeyHex);
            return keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
        }

        public PublicKey parseECPublicKey(String publicKeyHex) throws Exception {
            byte[] publicKey = Hex.decode(publicKeyHex);
            ECPoint publicPoint = ECPointUtil.decodePoint(params.getCurve(), publicKey);
            return keyFactory.generatePublic(new ECPublicKeySpec(publicPoint, params));
        }

        public PrivateKey parsePKCS8PrivateKey(String privateKeyHex) throws Exception {
            byte[] privateKey = Hex.decode(privateKeyHex);
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));
        }

        public KeyPair generateKeyPair() throws Exception {
            KeyPairGenerator g = KeyPairGenerator.getInstance(ALGO_EC, new BouncyCastleProvider());
            ECGenParameterSpec kpgparams = new ECGenParameterSpec(algorithm);
            g.initialize(kpgparams);
            return g.generateKeyPair();
        }

        public String getAlgorithm() {
            return algorithm;
        }

}
