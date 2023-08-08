package org.nhex.sinohope.api.util;

import org.apache.commons.lang3.StringUtils;
import org.nhex.sinohope.api.constants.Constants;
import org.nhex.sinohope.api.sign.ECDSA;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;

/**
 * @Title: SignerUtil
 * @Author lishuo
 * @Date 2023-05-31 11:14
 **/
public class SignerUtil {


  public static String getNonce() {
    return String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
  }

  public static String getSignMetaData(String nonce, String publicKey, String path, String data) {
    Map<String, String> map = new HashMap<>();
    map.put(Constants.TIMESTAMP, nonce);
    map.put(Constants.PATH, path);
    map.put(Constants.VERSION, "1.0.0");
    map.put(Constants.DATA, StringUtils.isNotBlank(data) ? data : "");
    return map.keySet().stream()
        .sorted(Comparator.naturalOrder())
        .map(key -> String.join("", key, map.get(key)))
        .collect(Collectors.joining()).trim()
        .concat(publicKey);
  }

  public static String[] doGenerateSignMetaDataAsString(String publicKey, String path, String data) {
    Map<String, String> map = new HashMap<>(4);
    map.put(Constants.TIMESTAMP, String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
    map.put(Constants.PATH, path);
    map.put(Constants.VERSION, "1.0.0");
    map.put(Constants.DATA, StringUtils.isNotBlank(data) ? data : "");
    String signMetaData = map.keySet().stream()
        .sorted(Comparator.naturalOrder())
        .map(key -> String.join("", key, map.get(key)))
        .collect(Collectors.joining()).trim()
        .concat(publicKey);
    return new String[]{signMetaData, map.get(Constants.TIMESTAMP)};
  }

  public static boolean verifySign(String apiKey, String signature, String paramSignature) {
    ECDSA ecdsa = null;
    try {
      ecdsa = new ECDSA(SECP256R1);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    try {
      return ecdsa.verify(paramSignature,
          ecdsa.parseX509PublicKey(apiKey),
          signature);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


}
