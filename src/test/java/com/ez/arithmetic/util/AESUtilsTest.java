package com.ez.arithmetic.util;

import org.junit.Test;

public class AESUtilsTest {

    @Test
    public void encrypt() throws Exception {
        String encrypt = AESUtils.encrypt("Awareness@2020");
        String decrypt = AESUtils.decrypt(encrypt);

        System.out.println("encrypt:" + encrypt);
        System.out.println("decrypt:" + decrypt);
    }
}
