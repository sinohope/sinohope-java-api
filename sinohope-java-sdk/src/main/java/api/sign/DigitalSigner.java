package api.sign;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * DigitalSigner
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class DigitalSigner {
    private static final String PUBLIC_KEY = "ECDSAPublicKey";
    private static final String PRIVATE_KEY = "ECDSAPrivateKey";

    /**
     * @return Map pub、pri key
     */
    public static Map<String, Object> initKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256, new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();
            Map<String, Object> keyMap = new HashMap<>(2);
            keyMap.put(PUBLIC_KEY, publicKey);
            keyMap.put(PRIVATE_KEY, privateKey);
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    /**
     * @param data signData
     * @param privKey  privatekey
     * @return byte[] crypt data
     */
    public static byte[] digitalSign(byte[] data, byte[] privKey) {
        try {
            PrivateKey privateKey = (PrivateKey) KeyFactory.getInstance("EC")
                    .generatePrivate(new PKCS8EncodedKeySpec(privKey));
            Signature signature = Signature.getInstance("SHA256WithECDSA");
            signature.initSign(privateKey);
            signature.update(data);
            return signature.sign();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @param data
     * @param pubKey  publicKey
     * @return verify result
     */
    public static boolean signVerify(byte[] data, byte[] rsaData, byte[] pubKey) {
        try {
            PublicKey publicKey = (PublicKey) KeyFactory.getInstance("EC")
                    .generatePublic(new X509EncodedKeySpec(pubKey));
            Signature signature = Signature.getInstance("SHA256WithECDSA");
            signature.initVerify(publicKey);
            signature.update(data);
            return signature.verify(rsaData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * @param keyMap
     * @return byte[] privateKey
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * @param keyMap
     * @return byte[] publicKey
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }
}
