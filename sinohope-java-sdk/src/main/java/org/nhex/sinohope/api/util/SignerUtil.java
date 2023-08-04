package org.nhex.sinohope.api.util;

import org.apache.commons.lang3.StringUtils;
import org.nhex.sinohope.api.constants.Constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: SignerUtil
 * @Author lishuo
 * @Date 2023-05-31 11:14
 **/
public class SignerUtil {

  @Deprecated
  public static String[] doGenerateSignMetaData(String publicKey, String path) {
    Map<String, String> map = new HashMap<>(4);
    map.put(Constants.TIMESTAMP, String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
//        System.out.println("BIZ-API-NONCE is -> " + map.get(Constants.TIMESTAMP));
    map.put(Constants.PATH, path);
    map.put(Constants.VERSION, "1.0.0");
    return new String[]{map.keySet().stream()
        .sorted(Comparator.naturalOrder())
//                .filter(key -> !Objects.equals(key, Constants.SIGN))
        .map(key -> String.join("", key, map.get(key)))
        .collect(Collectors.joining()).trim()
        .concat(publicKey)};
  }

  public static String[] doGenerateSignMetaDataAsString(String publicKey, String path, String data) {
    Map<String, String> map = new HashMap<>(4);
    map.put(Constants.TIMESTAMP, String.valueOf(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()));
//        System.out.println("BIZ-API-NONCE is -> " + map.get(Constants.TIMESTAMP));
    map.put(Constants.PATH, path);
    map.put(Constants.VERSION, "1.0.0");
    map.put(Constants.DATA, StringUtils.isNotBlank(data) ? data : "");
    String signMetaData = map.keySet().stream()
        .sorted(Comparator.naturalOrder())
//                .filter(key -> !Objects.equals(key, Constants.SIGN))
        .map(key -> String.join("", key, map.get(key)))
        .collect(Collectors.joining()).trim()
        .concat(publicKey);
    return new String[]{signMetaData, map.get(Constants.TIMESTAMP)};
  }

  public static String doBuildSignQueryString(Map<String, Object> parameters) {
    StringBuilder queryString = new StringBuilder();
    for (Map.Entry<String, Object> entry : parameters.entrySet()) {
      String key = entry.getKey();
      String value = String.valueOf(entry.getValue());
      queryString.append(key).append("=").append(value).append("&");
    }
    if (queryString.length() > 0) {
      queryString.setLength(queryString.length() - 1);
    }
    return queryString.toString();
  }

  public static String convertJsonToQueryString(Map<String, Object> json) {
    return "?" + json.entrySet().stream()
        .flatMap(entry -> {
          String key = entry.getKey();
          Object value = entry.getValue();
          try {
            if (value instanceof String) {
              return Stream.of(keyValuePair(key, (String) value));
            } else if (value instanceof List) {
              List<?> list = (List<?>) value;
              return list.stream().map(item -> {
                try {
                  return keyValuePair(key, item.toString());
                } catch (UnsupportedEncodingException e) {
                  throw new RuntimeException(e);
                }
              });
            }
          } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
          }
          return Stream.empty();
        })
        .collect(Collectors.joining("&"))
        .replaceAll("&+$", "");
  }

  private static String keyValuePair(String key, String value) throws UnsupportedEncodingException {
    return urlEncode(key) + "=" + urlEncode(value);
  }

  private static String urlEncode(String value) throws UnsupportedEncodingException {
    return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
  }
}
