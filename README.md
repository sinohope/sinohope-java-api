
# Sinohope Java API

sinohope-java-api is a lightweight Java library for interacting with the [Cobo Custody API](https://doc.custody.cobo.com/?#cobo-custody-waas-api), providing complete API coverage.


* [Installation](#installation)
* [Test](#test)
* [Usage](#usage)
    * [Initialize](#initialize)
        * [Generate Key Pair](#generate-key-pair)
        * [Initialize RestClient](#initialize-restclient)
        * [Initialize ApiSigner](#initialize-apisigner)

## Installation

Step 1. Add the JitPack repository to your build file

gradle:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

maven:

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency

gradle:

```
dependencies {
    implementation 'com.github.CoboCustody:cobo-java-api:v0.55'
}
```

maven:

```
<dependency>
    <groupId>com.github.CoboCustody</groupId>
    <artifactId>cobo-java-api</artifactId>
    <version>v0.55</version>
</dependency>
```



## Test

```
 ./gradlew test -DEnv=sandbox/prod -DApiSecret=<yourApiSecret>
```

## Usage

### Initialize

#### Generate Key Pair
```java
import com.cobo.custody.api.client.impl.LocalSigner;

String[] key = LocalSigner.generateKeyPair();
String secretKey = key[0];
String apiKey = key[1];
```
Please refer to the link [link](https://doc.custody.cobo.com/en.html#api-authentication) for how to use apiKey

#### Initialize RestClient
These can be instantiated through the corresponding factory method of `CoboApiClientFactory`

```java
import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.CoboApiConfig;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.impl.LocalSigner;

CoboApiRestClient client = CoboApiClientFactory.newInstance(
                new LocalSigner(apiSecret),
                Env.SANDBOX,
                false).newRestClient();
```

#### Initialize ApiSigner


`ApiSigner` can be instantiated through `new LocalSigner("secretkey" )`

In some cases, your private key cannot be exported, for example, your private key is in aws kms, you should pass in your own implementation by implements `ApiSigner` interface:


```java

import com.cobo.custody.api.client.ApiSigner;
new ApiSigner() {
    @Override
    public String sign(byte[] message) {
        return null;
    }

    @Override
    public String getPublicKey() {
        return null;
    }
}
```
