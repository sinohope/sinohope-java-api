package org.nhex.sinohope.client;

/**
 * @author wangfengchen
 */
public class Env {
//    public static Env DEVELOP = new Env("http://localhost:9195","3056301006072a8648ce3d020106052b8104000a03420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d", "30818d020100301006072a8648ce3d020106052b8104000a04763074020101042049888755bcb8bead7efd451426692cebd00c2aba9fad62a6f753343085a7c060a00706052b8104000aa14403420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d");
    public static Env DEVELOP = new Env("http://localhost:9195","3056301006072a8648ce3d020106052b8104000a03420004b6e4746d93e7727215d4124ccd0165e3a1bc9a9cc529fac248ce6f9c27c29bb082d3caf73a0649ee913fba730ffbecf50404ecf02bc2dd929016d2cb92478ffd", "30818d020100301006072a8648ce3d020106052b8104000a04763074020101042049888755bcb8bead7efd451426692cebd00c2aba9fad62a6f753343085a7c060a00706052b8104000aa14403420004d8caf9385ee3f28df77eab42a0da4b8dc9462a8ad39dbb224c2802cc377df9dc09ac23d04748b40c2897d91bbd7fe859476c6f6fe9b2aa82607e8a48f9b7ac0d");

    public String host;
    public String publicKey;
    public String privateKey;

    public Env(String host, String publicKey, String privateKey) {
        this.host = host;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

}
