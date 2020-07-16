package com.ez.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 大数相乘
 * 两个大数，求相乘结果
 */
public class TwoBigNumMulti {
    public static void main(String[] args) {
        String num1 = "123456";
        String num2 = "456789";
    }

    /**
     * 方法1:暴力算法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String simpleSolution(String num1, String num2) {
        char[] rs = new char[num1.length() + num2.length()];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        //todo
        return rs.toString();
    }

}
