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
  public void testSdkPostNoParameters() {
    ResultData<Void> res = client.testSdkPostNoParameters();
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
  public void testSdkVerifyPostNoParameters() {
    String apiKey = "3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    String signature = "30450220381219f70dd766e2e417142bde93c8ce5b387de6ccb2e92ed17ea5ce31aeb630022100a2d9da9bb13dd83712040d63a74cde1850111abc779071b710e85ffe2a374579";
    String paramSignature = "datapath/v1/testSdkPostNoParameterstimestamp1695277889626version1.0.03056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d";
    boolean verifySign = SignerUtil.verifySign(apiKey, signature, paramSignature);
    System.out.println(verifySign);
  }

  public static void main(String[] args) {
    String apiKey = "3059301306072a8648ce3d020106082a8648ce3d030107034200045e7fd47ab181bf36528ead76730223f7a06333ccd1307adaedbfde0f26a715e39973f6434e1a60f9cf80a5c382824db1ff07c4d28f06eba4da4502e60cf5e7ef";
    String signature = "304502200faa004cff3d456c79b19e17c87af00661b7b3d8aaa53a174c075b3f0ab3b855022100a2825790fb579bb2413c001b84bab75b675cfc27b69f45ae1986e2b44a02f709";
    String paramSignature = "data{\"pageIndex\":0,\"pageSize\":10}path/v1/waas/mpc/wallet/list_walletstimestamp1695283096468version1.0.03059301306072a8648ce3d020106082a8648ce3d030107034200045e7fd47ab181bf36528ead76730223f7a06333ccd1307adaedbfde0f26a715e39973f6434e1a60f9cf80a5c382824db1ff07c4d28f06eba4da4502e60cf5e7ef";
    boolean verifySign = SignerUtil.verifySign(apiKey, signature, paramSignature);
    System.out.println(verifySign);
  }

}
