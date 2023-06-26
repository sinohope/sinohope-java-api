# Sinohope Java API

sinohope-java-api is a lightweight Java library for interacting with the [Sinohope Custody API](https://www.newhuotech.com/), providing complete API coverage.


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
    <version>1.1.0</version>
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

String dataString;

//POST
//String postData = "{\n" +
//        "  \"name\": \"John\",\n" +
//        "  \"age\": \"30\",\n" +
//        "  \"city\": \"New York\",\n" +
//        "  \"hobbies\": [\"reading\", \"playing-guitar\", \"painting\"]\n" +
//        "}";
        
//ObjectMapper objectMapper = new ObjectMapper();
//Map<String, Object> jsonMap = objectMapper.readValue(postData, Map.class);
//dataString =  convertJsonToQueryString(jsonMap);

//Get
dataString ="?name=John&id=30";

// privateKey is use  before step final result
String[] msg = doGenerateSignMetaDataAsString(publicKey, "/you-project-path/demo/save",dataString);
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
