package org.nhex.sinohope.client;

import com.alibaba.fastjson2.JSON;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;
import org.nhex.sinohope.api.sign.ECDSA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import static org.nhex.sinohope.api.util.SignerUtil.doGenerateSignMetaDataAsString;

/**
 * @author wangfengchen
 */
public class AuthenticationInterceptor implements Interceptor {

  private final String apiKey;

  private final ECDSA signer;

  private final String privateKey;


  public AuthenticationInterceptor(ECDSA signer, String publicKey, String privateKey) {
    this.signer = signer;
    this.apiKey = publicKey;
    this.privateKey = privateKey;
  }

  /**
   * Extracts the request body into a String.
   *
   * @return request body as a string
   */

  private static String bodyToSortedString(RequestBody body) throws UnsupportedEncodingException {
    if (body instanceof FormBody) {
      FormBody newBody = (FormBody) body;
      TreeMap<String, Object> map = new TreeMap<>();
      for (int i = 0; i < newBody.size(); i++) {
        map.put(newBody.encodedName(i), URLDecoder.decode(newBody.encodedValue(i), "UTF-8"));
      }

//      return composeParams(map);
      return JSON.toJSONString(map);
    }
    throw new IllegalArgumentException("Unsupported request body");

  }

  private static String composeParams(TreeMap<String, Object> params) {
    StringBuffer sb = new StringBuffer();
    params.forEach((s, o) -> {
      try {
        sb.append(s).append("=").append(URLEncoder.encode(String.valueOf(o), "UTF-8")).append("&");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    });
    if (sb.length() > 0) {
      sb.deleteCharAt(sb.length() - 1);
    }
    return sb.toString();
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();
    Request.Builder newRequestBuilder = original.newBuilder();

    Request newRequest = addHeader(original, newRequestBuilder);
    Response response = chain.proceed(newRequest);
    String responseBody = response.body() == null ? "null" : response.body().string();
    MediaType mediaType = response.body().contentType();
    return response.newBuilder()
        .body(ResponseBody.create(mediaType, responseBody))
        .build();
  }

  private Request addHeader(Request original, Request.Builder newRequestBuilder) throws UnsupportedEncodingException {
    String method = original.method();
    String path = pathSegmentsToString(original.url().pathSegments());
    String body;
    if ("GET".equals(method)) {
      HttpUrl url = original.url();
      Set<String> names = url.queryParameterNames();
      TreeMap<String, Object> params = new TreeMap<>();
      for (String name : names) {
        params.put(name, url.queryParameter(name));
      }
      body = composeParams(params);
    } else if ("POST".equals(method)) {
      RequestBody requestBody = original.body();
      Buffer buffer = new Buffer();
      try {
        requestBody.writeTo(buffer);
      } catch (IOException e) {
        e.printStackTrace();
      }
      //编码设为UTF-8
      Charset charset = StandardCharsets.UTF_8;
      MediaType contentType = requestBody.contentType();
      if (contentType != null) {
        charset = contentType.charset(StandardCharsets.UTF_8);
      }
      //拿到request
      body = buffer.readString(charset);
    } else {
      throw new RuntimeException("not supported http method");
    }
    if (StringUtils.isNotBlank(body)) {
      body = body.replaceAll(" ", "").replaceAll("\n", "");
    }
    String[] msg = doGenerateSignMetaDataAsString(apiKey, path, body);
    String sign = null;
    try {
      sign = signer.sign(msg[0], signer.parsePKCS8PrivateKey(privateKey));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    newRequestBuilder.addHeader(ApiConstants.BIZ_API_KEY, apiKey)
        .addHeader(ApiConstants.BIZ_API_NONCE, msg[1])
        .addHeader("X-EXCHANGE-ID", "1002")
//        .addHeader("Authorization", "bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIwYjQ2ZmFlZmI0YWI0N2I1OGNhZmY5Mjc0YzIxM2M4NyIsInVzZXJJZCI6NjQwMDAwMSwiZXhjaGFuZ2VJZCI6MTAwMiwiaWF0IjoxNjkwOTY4OTY5LCJleHAiOjE2OTEwNTUzNjl9.JKaBLAhACldEVW2CTWQ3ADXeeS6y1alF1kZuTBXeHfR50J5Gmrqrq3MQ67NQelQkObu7rzNrw86XC1pk3NjHdw")
//        .addHeader("X-USER-ID", "6400000")
        .addHeader(ApiConstants.BIZ_API_SIGNATURE, sign);
    System.out.println("待签名数据 = " + msg[0]);
    System.out.println("时间戳 = " + msg[1]);
    System.out.println("签名 = " + sign);
    return newRequestBuilder.build();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
    return Objects.equals(apiKey, that.apiKey) &&
        Objects.equals(signer, that.signer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey, signer);
  }

  String pathSegmentsToString(List<String> pathSegments) {
    StringBuilder out = new StringBuilder();
    for (String pathSegment : pathSegments) {
      out.append('/');
      out.append(pathSegment);
    }
    return out.toString();
  }
}