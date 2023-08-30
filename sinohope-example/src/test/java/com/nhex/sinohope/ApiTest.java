package com.nhex.sinohope;

import com.alibaba.fastjson.JSON;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhex.sinohope.api.sign.ECDSA;
import org.nhex.sinohope.api.util.SignerUtil;
import org.nhex.sinohope.client.*;
import org.nhex.sinohope.pojo.EmailLoginFeignRequest;
import org.nhex.sinohope.pojo.SettlementFinishDTO;
import org.nhex.sinohope.pojo.SettlementFinishDetailDTO;

import java.security.KeyPair;
import java.util.*;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;

/**
 * @author wangfengchen
 */
public class ApiTest {


  private ApiClient client;
  private ECDSA ecdsa;

  @BeforeEach
  public void setUp() {
    try {
      ecdsa = new ECDSA(SECP256R1);
      client = ApiClientFactory.newInstance(
          ecdsa,
          Env.DEVELOP).newRestClient();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void generateKeyPair() throws Exception {
    KeyPair keyPair = ecdsa.generateKeyPair();
    String publicKey = Hex.toHexString(keyPair.getPublic().getEncoded());
    String privateKey = Hex.toHexString(keyPair.getPrivate().getEncoded());
    System.out.println("publicKey = " + publicKey);
    System.out.println("privateKey = " + privateKey);
    System.out.println("1 = " + keyPair.getPublic());
    System.out.println("2 = " + keyPair.getPrivate());
    System.out.println("3 = " + ecdsa.parseX509PublicKey(publicKey));
    System.out.println("4 = " + ecdsa.parsePKCS8PrivateKey(privateKey));
  }

  @Test
  public void testPostWithList() {
    WaasApiRequest request = new WaasApiRequest();
    request.setApiType(0);
    request.setApiList(new LinkedHashSet<>(Arrays.asList("/user-auth-c/ua/waas/getValueByApiKey", "/user-auth-c/ua/user/existId", "/user-auth-c/ua/waas/add")));
    ResultData<Void> res = client.add(request);
    System.out.println(res);
  }

  @Test
  public void testPost() {
    TransferRequest request = new TransferRequest();
    request.setWalletId("433427713121093");
    request.setChainId("6");
    request.setAssetId("12");
    request.setAmount("1000000000000000");
    request.setFrom("0xe02d074693625c145de272a290790fd87c209457");
    request.setTo("0xe02d074693625c145de272a290790fd87c209457");
    request.setGasLimit("21000");
    request.setGasPrice("32550000000");
    request.setFee("683550000000000");
    request.setGaAuthCode("200226");
    request.setAmountType(1);
    ResultData<Void> res = client.transfer(request);
    System.out.println(res);
  }

  @Test
  public void testPost2() {
    EmailLoginFeignRequest request = new EmailLoginFeignRequest();
    request.setClientType(3);
    request.setKickOutTag("mpc:login:type:APP");
    request.setAccessTokenExpiration(60000000L);
    request.setRefreshTokenExpiration(60000000L);
    request.setExchangeId(1002);
    request.setEmail("wangfengchen@newhuotech.com");
    ResultData<Void> res = client.testPost2(request);
    System.out.println(res);
  }

  @Test
  public void testGetWithParam() {
    ResultData<Void> res = client.getValueByApiKey(Env.DEVELOP.publicKey);
    System.out.println(res);
  }

  @Test
  public void testGet() {
    ResultData<Void> res = client.existId();
    System.out.println(res);
  }

  @Test
  public void testPostFormData() {
    Map<String, String> request = new HashMap<>();
    request.put("apiType", "0");
    request.put("apiList", "/user-auth-c/ua/waas/getValueByApiKey, /user-auth-c/ua/user/existId, /user-auth-c/ua/waas/add");
    ResultData<Void> res = client.add2(JSON.toJSONString(request));
    System.out.println(res);
  }

  @Test
  public void testPostWithObjectAndList() {
    SettlementFinishDTO request = SettlementFinishDTO.builder()
        .settlementId("434094777691909")
        .cvaId("433366151883589")
        .data(Collections.singletonList(
            SettlementFinishDetailDTO.builder()
                .assetId("USDT_BNB_TEST")
                .status("COMPLETED")
                .txHash("0xaacfdfc5cd215eb35f5a3a966dda3ac8ee765ccc7070459c4c4951dc3f715d19")
                .build()
        )).build();
    ResultData<Void> res = client.add3(request);
    System.out.println(res);
  }

  @Test
  public void testVerify() {
    boolean verifySign = SignerUtil.verifySign("3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d",
        "304502200668ed857706a4d635c5dca7e208cf7f5a0a7c8e91645f87613fcefa0007647602210083313d030e8a3ef8cb6909286a7a06de7cdd23a4333d56358cc903def383eb56",
        "data{\"clientType\":3,\"kickOutTag\":\"mpc:login:type:APP\",\"accessTokenExpiration\":60000000,\"refreshTokenExpiration\":60000000,\"exchangeId\":1002,\"email\":\"wangfengchen@newhuotech.com\"}path/ua/appKey/testtimestamp1693316852274version1.0.03056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d");
    System.out.println(verifySign);
  }


}
