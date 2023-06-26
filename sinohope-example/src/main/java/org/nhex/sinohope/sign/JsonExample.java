package org.nhex.sinohope.sign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title:
 * @Author lishuo
 * @Date 2023-06-21 10:43
 **/
public class JsonExample {

    public static String convertJsonToQueryString(Map<String, Object> json) {
        return json.entrySet().stream()
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
                .collect(Collectors.joining("&"));
    }

    private static String keyValuePair(String key, String value) throws UnsupportedEncodingException {
        return urlEncode(key) + "=" + urlEncode(value);
    }

    private static String urlEncode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": \"30\",\n" +
                "  \"city\": \"New York\",\n" +
                "  \"hobbies\": [\"reading\", \"playing-guitar\", \"painting\"]\n" +
                "}";


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parse JSON into a map
            Map<String, Object> jsonMap = objectMapper.readValue(json, Map.class);

            // Convert JSON to query string
            String queryString = "?" + convertJsonToQueryString(jsonMap); // 添加开头的问号
            queryString = queryString.replaceAll("&+$", ""); // 去掉末尾的多余的“&”
            System.out.println(queryString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
