package com.sinohope.auth;

import com.sinohope.constant.ApiConstants;
import com.sinohope.constant.ErrorCodeConstant;
import com.sinohope.exception.MpcException;
import com.sinohope.util.SignerUtil;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.sinohope.sign.ECDSA;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wangfengchen
 */
public class AuthenticationInterceptor implements Interceptor {
  private static final Logger log = Logger.getLogger(AuthenticationInterceptor.class.getName());

  private final String apiKey;

  private final ECDSA signer;

  private final String privateKey;


  public AuthenticationInterceptor(ECDSA signer, String publicKey, String privateKey) {
    this.signer = signer;
    this.apiKey = publicKey;
    this.privateKey = privateKey;
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

  private Request addHeader(Request original, Request.Builder newRequestBuilder) {
    String method = original.method();
    String path = pathSegmentsToString(original.url().pathSegments());
    log.info("请求path=" + original.url().url());
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
      throw new MpcException(ErrorCodeConstant.UN_SUPPORT_METHOD, "not supported http method");
    }
    String[] msg = SignerUtil.generateSignMetaData(apiKey, path, body);
    String sign = null;
    try {
      sign = signer.sign(msg[0], signer.parsePKCS8PrivateKey(privateKey));
    } catch (Exception e) {
      log.log(Level.SEVERE, "sdk签名失败，异常原因:{0}", ExceptionUtils.getRootCause(e));
      throw new MpcException(ErrorCodeConstant.SIGNATURE_ERROR, "签名失败");
    }
    newRequestBuilder.addHeader(ApiConstants.BIZ_API_KEY, apiKey)
        .addHeader(ApiConstants.BIZ_API_NONCE, msg[1])
        .addHeader(ApiConstants.BIZ_API_SIGNATURE, sign);
    log.info("时间戳 = " + msg[1]);
    log.info("签名 = " + sign);
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