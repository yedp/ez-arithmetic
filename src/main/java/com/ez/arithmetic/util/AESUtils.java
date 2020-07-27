package com.ez.arithmetic.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 对称加密
 */
public class AESUtils {
    private static final String AES_KEY = "Consciousness@20";

    public static String encrypt(String sSrc) throws Exception {
        return encrypt(sSrc, AES_KEY);
    }

    public static String decrypt(String sSrc) throws Exception {
        return decrypt(sSrc, AES_KEY);
    }

    public static String encrypt(String sSrc, String key) throws Exception {
        byte[] raw = key.getBytes("UTF-8");
        SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, keySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));
        return parseByte2HexStr(encrypted);
    }

    public static String decrypt(String sSrc, String key) throws Exception {
        byte[] raw = key.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, skeySpec);
        byte[] encrypted1 = parseHexStr2Byte(sSrc);
        if (encrypted1 == null) {
            return null;
        } else {
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "UTF-8");
        }
    }

    private static String parseByte2HexStr(byte[] buffer) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buffer.length; ++i) {
            String hex = Integer.toHexString(buffer[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for (int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }

            return result;
        }
    }

}
