package com.nhex.sinohope;

import com.alibaba.fastjson.JSON;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nhex.sinohope.api.sign.ECDSA;
import org.nhex.sinohope.api.util.SignerUtil;
import org.nhex.sinohope.client.*;
import org.nhex.sinohope.pojo.SettlementFinishDTO;
import org.nhex.sinohope.pojo.SettlementFinishDetailDTO;
import org.nhex.sinohope.pojo.UserSdk;

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
  public void testSdkGet() {
    ResultData<Void> res = client.testSdkGet("key", "value");
    System.out.println(res);
  }

  @Test
  public void testSdkPost() {
    UserSdk request = new UserSdk();
    request.setKey("key");
    request.setValue("value");
    ResultData<Void> res = client.testSdkPost(request);
    System.out.println(res);
  }

  @Test
  public void testSdkPostNoBody() {
    ResultData<Void> res = client.testSdkPostNoBody();
    System.out.println(res);
  }

  @Test
  public void testSdkVerifyGet() {
    String apiKey = "3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    String signature = "3045022100e8ec2e4268afa90f2ce32f9ee6a17c6594d13584f6d2f7e14017c037eab021f3022034b71ba605b68b9d8fde88ab88c695d4e9446632c6d1e8652c442ad761480e23";
    String paramSignature = "datakey=key&value=valuepath/test/testSdkGettimestamp1693468183730version1.0.03056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    boolean verifySign = SignerUtil.verifySign(apiKey, signature, paramSignature);
    System.out.println(verifySign);
  }

  @Test
  public void testSdkVerifyPost() {
    String apiKey = "3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    String signature = "3046022100cc2dbb5605253b23949c4f50e2826112a2c661ab830af14386a432ad86885343022100d0b378e74a49cd856039f898d9de5a7af3ae284de951244ee57d85adf9786752";
    String paramSignature = "data{\"key\":\"key\",\"value\":\"value\"}path/test/testSdkPosttimestamp1693468274893version1.0.03056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    boolean verifySign = SignerUtil.verifySign(apiKey, signature, paramSignature);
    System.out.println(verifySign);
  }

  @Test
  public void testSdkVerifyPostNoBody() {
    String apiKey = "3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    String signature = "3045022100c2aa82dbe61140ba2ac3d056e6e4b1d84e7de243d528f7b27dd30b3bec065a1602203f6aaa76d5d33e999c2181f72ca59bc6895489aaee26347e4eb3257b2ce95ff0";
    String paramSignature = "datapath/v1/testSdkPostNoBodytimestamp1695277164656version1.0.03056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    boolean verifySign = SignerUtil.verifySign(apiKey, signature, paramSignature);
    System.out.println(verifySign);
  }


}
