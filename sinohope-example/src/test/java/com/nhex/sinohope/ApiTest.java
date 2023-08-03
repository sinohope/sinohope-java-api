package com.nhex.sinohope;

import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import org.nhex.sinohope.api.sign.ECDSA;

import java.security.KeyPair;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256K1;

/**
 * @author wangfengchen
 */
public class ApiTest {


  @Test
  public void getPublicKeyAndPrivateKey() throws Exception {
    ECDSA ecdsa = new ECDSA(SECP256K1);
    KeyPair keyPair = ecdsa.generateKeyPair();
    String publicKey = Hex.toHexString(keyPair.getPublic().getEncoded());
    String privateKey = Hex.toHexString(keyPair.getPrivate().getEncoded());
    System.out.println("publicKey = " + publicKey);
    System.out.println("privateKey = " + privateKey);
  }


}
