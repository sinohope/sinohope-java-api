# Sinohope Java API

sinohope-java-api is a lightweight Java library for interacting with the [Sinohope WaaS API](https://sinohope.github.io/api/), providing complete API coverage.


* [Installation](#installation)
* [Test](#test)
* [Usage](#usage)
  * [Generate Key Pair](#generate-key-pair)
  * [Generate Signature](#generate-signature)
  * [Validate Signature](#validate-signature)

## Installation
Step 1. Add the dependency

maven:
```
<dependency>
    <groupId>com.sinohope</groupId>
    <artifactId>sinohope-java-sdk</artifactId>
    <version>1.1.5</version>
</dependency>
```


## Test

```
 run org.nhex.sinohope.sign.ApplicationEcdsaExample
```

## Usage


### Generate Key Pair
```java
import org.nhex.sinohope.sign.api.ECDSA;

ECDSA ecdsa = new ECDSA(SECP256R1);
KeyPair keyPair = ecdsa.generateKeyPair();
String publicKey = Hex.toHexString(keyPair.getPublic().getEncoded());
String privateKey = Hex.toHexString(keyPair.getPrivate().getEncoded());
System.out.println("publicKey = " + publicKey);
System.out.println("privateKey = " + privateKey);
```
Please refer to the link [link](https://sinohope.github.io/api/) for how to use apiKey

### Generate Signature
Calling this method generates a signature using the ecdsa encryption algorithm.

```java
import org.nhex.sinohope.sign.api.ECDSA;
import static org.nhex.sinohope.sign.api.ECDSA.SECP256R1;
import static org.nhex.sinohope.util.api.SignerUtil.doGenerateSignMetaDataAsString;

ECDSA ecdsa = new ECDSA(SECP256R1);


//Post
YourBizDto yourBizDto = YourBizDto.builder()
        .settlementId("434094777691909")
        .cvaId("433366151883589")
        .data(Arrays.asList(
            YourBizSubDto.builder()
            .assetId("USDT_BNB_TEST")
            .status("COMPLETED")
            .txHash("0xaacfdfc5cd215eb35f5a3a966dda3ac8ee765ccc7070459c4c4951dc3f715d19")
            .build()
        )).build();
String[] msg = generateSignMetaData(publicKey, "/you-project-path/demo/test/json2", JSON.toJSONString(yourBizDto));


//Get
Map<String,Object> paramMap = new LinkedHashMap<>();
paramMap.put("id", "098343230");
paramMap.put("name", "test");
String[] msg = generateSignMetaData(publicKey, "/you-project-path/demo/order/findById",composeParams(paramMap));

//chose Post or Get request type
// privateKey is use  before step final result

System.out.println("signature data is ->" + msg[0]);
System.out.println("request nonce is ->" + msg[1]);

String signature = ecdsa.sign(msg[0], ecdsa.parsePKCS8PrivateKey(privateKey));
System.out.println("signature is ->" + signature);
```

### Validate Signature
Calling this method verifies that the signature of the ecdsa encryption algorithm is correct.


```java
import org.nhex.sinohope.sign.api.ECDSA;
import static org.nhex.sinohope.sign.api.ECDSA.SECP256R1;
import static org.nhex.sinohope.util.api.SignerUtil.doGenerateSignMetaDataAsString;

ECDSA ecdsa = new ECDSA(SECP256R1);

//signature is use before step final result
//msg is msg[0]
ecdsa.verify(msg, ecdsa.parseX509PublicKey(publicKey), signature));
```
