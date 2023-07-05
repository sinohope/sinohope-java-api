# Sinohope Java API

sinohope-java-api is a lightweight Java library for interacting with the [Sinohope Custody API](https://sinohope.github.io/openloop/index.html#tag/Exchange-greaterCustody/paths/~1collateral~1v1~1address~1status/post), providing complete API coverage.


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
    <groupId>org.nhex.sinohope</groupId>
    <artifactId>sinohope-java-api</artifactId>
    <version>1.1.1</version>

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

KeyPair pair = ecdsa.generateKeyPair();
String privateKey = Hex.toHexString(pair.getPrivate().getEncoded());
String publicKey = Hex.toHexString(pair.getPublic().getEncoded());
System.out.println("publicKey is ->" + publicKey);
System.out.println("privateKey is ->" + privateKey);
```
Please refer to the link [link](https://doc.custody.cobo.com/en.html#api-authentication) for how to use apiKey

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
String[] msg = doGenerateSignMetaDataAsString(publicKey, "/you-project-path/demo/test/json2", JSON.toJSONString(yourBizDto));


//Get
Map<String,Object> paramMap = new LinkedHashMap<>();
paramMap.put("id", "098343230");
paramMap.put("name", "test");
String[] msg = doGenerateSignMetaDataAsString(publicKey, "/you-project-path/demo/order/findById",doBuildSignQueryString(paramMap));

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
