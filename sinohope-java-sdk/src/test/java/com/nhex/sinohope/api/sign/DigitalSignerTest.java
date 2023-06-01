package com.nhex.sinohope.api.sign;


import api.sign.DigitalSigner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * com.nhex.sinohope.api.sign.DigitalSignerTest
 *
 * @author lishuo
 * @date 2023/5/24 10:46
 **/
public class DigitalSignerTest {

    private static byte[] publicKey;
    private static byte[] privateKey;

    private static String data = "{\n" +
            "  \"name\": \"John Doe\",\n" +
            "  \"age\": 30,\n" +
            "  \"email\": \"johndoe@example.com\",\n" +
            "  \"address\": {\n" +
            "    \"street\": \"123 Main St\",\n" +
            "    \"city\": \"New York\",\n" +
            "    \"state\": \"NY\",\n" +
            "    \"postalCode\": \"10001\"\n" +
            "  },\n" +
            "  \"phoneNumbers\": [\n" +
            "    \"123-456-7890\",\n" +
            "    \"987-654-3210\"\n" +
            "  ],\n" +
            "  \"isEmployed\": true,\n" +
            "  \"education\": {\n" +
            "    \"degree\": \"Bachelor's\",\n" +
            "    \"major\": \"Computer Science\"\n" +
            "  },\n" +
            "  \"interests\": [\"reading\", \"traveling\", \"cooking\"],\n" +
            "  \"lastLogin\": \"2023-05-18T12:00:00Z\"\n" +
            "}\n";

    @BeforeAll
    public static void setupKeys() {
        Map<String, Object> keyMap = DigitalSigner.initKey();
        publicKey = DigitalSigner.getPublicKey(keyMap);
        privateKey = DigitalSigner.getPrivateKey(keyMap);
    }

    @Test
    public void testKeyGeneration() {
        assertTrue(publicKey != null && publicKey.length > 0);
        assertTrue(privateKey != null && privateKey.length > 0);
    }

    @Test
    public void testSignAndVerify() {
        byte[] signature = DigitalSigner.digitalSign(data.getBytes(), privateKey);
        assertTrue(signature != null && signature.length > 0);

        boolean verified = DigitalSigner.signVerify(data.getBytes(), signature, publicKey);
        assertTrue(verified);
    }
}
