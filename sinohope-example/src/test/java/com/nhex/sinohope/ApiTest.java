package com.nhex.sinohope;

import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;
import com.sinohope.sign.ECDSA;

import java.security.KeyPair;

import static com.sinohope.sign.ECDSA.SECP256R1;

/**
 * @author wangfengchen
 */
public class ApiTest {


  @Test
  public void getPublicKeyAndPrivateKey() throws Exception {
    ECDSA ecdsa = new ECDSA(SECP256R1);
    KeyPair keyPair = ecdsa.generateKeyPair();
    String publicKey = Hex.toHexString(keyPair.getPublic().getEncoded());
    String privateKey = Hex.toHexString(keyPair.getPrivate().getEncoded());
    System.out.println("publicKey = " + publicKey);
    System.out.println("privateKey = " + privateKey);
  }


}
