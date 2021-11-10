package com.ez.arithmetic.leetcode;

/**
 * @author daoping.ye
 * 5.给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public interface IL5LongestPalindrome {
    /**
     * 暴力破解法
     *
     * @param s
     * @return
     */
    String exhaustSolution(String s);
}
