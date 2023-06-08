package org.nhex.sinohope.api.util;

import org.nhex.sinohope.api.constants.Constants;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Title: SignerUtil
 * @Author lishuo
 * @Date 2023-05-31 11:14
 **/
public class SignerUtil {


    public static  byte[] doGenerateSignMetaData(String publicKey, String path) {
        Map<String, String> map =  new HashMap<>(3);
        map.put(Constants.TIMESTAMP, String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        System.out.println("BIZ-API-NONCE is -> " +map.get(Constants.TIMESTAMP));
        map.put(Constants.PATH, path);
        map.put(Constants.VERSION, "1.0.0");
        return map.keySet().stream()
                .sorted(Comparator.naturalOrder())
                .filter(key -> !Objects.equals(key, Constants.SIGN))
                .map(key -> String.join("", key, map.get(key)))
                .collect(Collectors.joining()).trim()
                .concat(publicKey).getBytes();
    }

    public static  String doGenerateSignMetaDataAsString(String publicKey, String path) {
        Map<String, String> map =  new HashMap<>(3);
        map.put(Constants.TIMESTAMP, String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        System.out.println("BIZ-API-NONCE is -> " +map.get(Constants.TIMESTAMP));
        map.put(Constants.PATH, path);
        map.put(Constants.VERSION, "1.0.0");
        return map.keySet().stream()
                .sorted(Comparator.naturalOrder())
                .filter(key -> !Objects.equals(key, Constants.SIGN))
                .map(key -> String.join("", key, map.get(key)))
                .collect(Collectors.joining()).trim()
                .concat(publicKey);
    }
}
