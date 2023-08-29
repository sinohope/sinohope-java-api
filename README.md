# SINOHOPE-JAVA-SDK

## 简介
欢迎使用 Sinohope Waas（Wallet as a Service） API。

[Sinohope 平台](https://www.sinohope.com/)是一站式的数字资产托管平台，同时支持自托管（基于MPC-TSS 技术）/全托管（基于 HSM 技术）产品，也支持以 API 的方式来使用相应的产品，满足广大客户的各类需求。

简要介绍 Sinohope 产品优势：


安全
- 综合 Tier 1 MPC-TSS  技术服务提供商
  基于全球最新 MPC-CMP 协议创新研发
  多重灾备方案，多场景分片恢复机制
- 完备的安全体系
  软件与硬件结合双结合（MPC-TSS+TEE）
  密码学和完备安全机制双保障

经验
- 十年数字资管经验
  10年+ 全球 Top3 交易所资管经验
  团队成员来自全球顶级高校与企业
- 百亿资金托管经验
  150亿+ USD 数字资产托管经验
  数十亿笔交易处理经验

资质：
- 多监管区域持牌
  隶属香港上市公司，代码：1611
  持有香港4/9号牌/TCSP  牌照
  获得 SOC 2 Type1 和  Type2  审计报告
- 交易安全性
  平台集成  AML/KYT  实时监控能力
  交易目标黑白名单/交易复核/规则设置

功能：
- 易用且强大的产品功能
  10秒创建钱包，功能易上手，Web2 体验
  多角色/多层级/多节点审批流/自定义交易规则引擎
  多种托管模式：协管/全托管/合规托管
- 多应用场景解决方案
  企业财务多层审批解决方案
  钱包基础设施/支付解决方案/国库解决方案

扩展：
- 多种访问方式
  APP + 网页版，无缝使用
  API + SDK，应对客户多种开发需求
- 面向 Web3 未来
  DApp/DeFi/NFT 支持
  链上资管/链上投融资 支持




# 快速开始
## 依赖引用

方式一：
sinohope-java-sdk依赖已推送至中央仓库，研发人员仅需要引入下方依赖即可快速集成：
```xml
<dependency>
  <groupId>com.sinohope</groupId>
  <artifactId>sinohope-java-sdk</artifactId>
  <version>2.0.0</version>
</dependency>
```
方式二：您也可以通过github(https://github.com/sinohope/sinohope-java-api) 下载源码进入sinohope-java-sdk进行重新打包。

## java版本说明：

推送至中央仓库的sdk是使用java 8 进行编译，如果您当前开发版本低于此版本推荐您使用方式二重新下载打包编译。

## 客户端

### 获取公私钥
初始化客户端之前您需要先获取一堆ECDSDA密钥对用户对WaaS API 请求进行鉴权，我们再SDK中已经提供了该方法。您需要获取一个ECDSA的实例，然后调用该实例的 `generateKeyPair()` 函数来获取一个`KeyPair`
对象，调用该对象的 `getPublic()`、`getPrivate()`函数从而获取到公私钥，再对公私钥结果进行16进制转换为字符串即可。

代码示例：
```java
  public void generateKeyPair() throws Exception {
    KeyPair keyPair = ecdsa.generateKeyPair();
    String publicKey = Hex.toHexString(keyPair.getPublic().getEncoded());
    String privateKey = Hex.toHexString(keyPair.getPrivate().getEncoded());
    System.out.println("publicKey = " + publicKey);
    System.out.println("privateKey = " + privateKey);
  }

```

### 初始化

我们的sdk客户端分为四种类型，分别是：

- 钱包地址客户端
- 交易相关客户端
- 高级功能客户端
- MpcNode客户端

我们在ClientFactory.class 中已经提供了各类客户端的创建方式，您可以直接使用我们提供的构造这些客户端的方法，这些方式是线程安全的，您可以放心使用。

示例代码如下：

```java

package xxxx;


import cn.hutool.extra.spring.SpringUtil;
import com.sinohope.client.ClientFactory;
import com.sinohope.client.MpcNodeClient;
import com.sinohope.client.SeniorClient;
import com.sinohope.client.TransactionClient;
import com.sinohope.client.WalletAndAddressClient;
import org.nhex.sinohope.api.sign.ECDSA;

import static org.nhex.sinohope.api.sign.ECDSA.SECP256R1;

public class WaasApiClient {

  public static String env;

  public static ECDSA ecdsa;
  private String publicKey = "xxxxxxxx";

  private String privateKey = "xxxxxxx";

  static String baseUrl = null;

  public WaasApiClient() throws Exception {

  }

  static {     
    try {
      baseUrl = "https://domain";
      ecdsa = new ECDSA(SECP256R1);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 构造钱包和地址相关客户端
   * @param publicKey
   * @param privateKey
   * @return
   */
  public static WalletAndAddressClient getWalletAndAddressClient(String publicKey,String privateKey) {
    return ClientFactory.newInstance(ecdsa, baseUrl, publicKey, privateKey).newWalletAndAddressClient();
  }

  /**
   * 构造交易客户端
   * @param publicKey
   * @param privateKey
   * @return
   */

  public static TransactionClient getTransactionClient(String publicKey,String privateKey) {
    return ClientFactory.newInstance(ecdsa, baseUrl, publicKey, privateKey).newTransactionClient();
  }

  /**
   * 构造高级功能客户端
   * @param publicKey
   * @param privateKey
   * @return
   */
  public static SeniorClient getSeniorClient(String publicKey,String privateKey) {
    return ClientFactory.newInstance(ecdsa, baseUrl, publicKey, privateKey).newSeniorClient();
  }

  /**
   * 构造mpcNode客户端
   * @param publicKey
   * @param privateKey
   * @return
   */
  public static MpcNodeClient getMpcNodeClient(String publicKey, String privateKey) {
    return ClientFactory.newInstance(ecdsa, baseUrl, publicKey, privateKey).newMpcNodeClient();
  }
  
}

```

### API使用
我们在SDK中已经封装了所有的WaaS相关的接口以及签名，您可以直接使用sdk中各类客户端中提供的方法。

代码示例：
```java

/**
   * 查询某条链下支持的币种
   *
   * @param request
   * @return
   */
  public ResultData<List<WaasChainVO>> getSupportedChains() {
    String publicKey = "xxxxxxxxx";
    String privateKey = "xxxxxxxxx";
    WalletAndAddressClient walletAndAddressClient = WaasApiClient.getWalletAndAddressClient(publicKey, privateKey);
    return walletAndAddressClient.getSupportedChains();
  }

```
至此，sinohope-java-sdk集成以及使用方式已经介绍完毕。

# 联系我们
如果您在使用中有任何问题，可以随时提出issues(https://github.com/sinohope/sinohope-java-api/issues)我们将快速解答您的问题。






