package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL3LengthOfLongestSubstring;

import java.util.*;

/**
 * @Author daoping.ye
 * @Date 2020/7/29 14:49
 * @Desc
 */
public class L3LengthOfLongestSubstringV2SlidingWindowOptimize implements IL3LengthOfLongestSubstring {

    /**
     * 滑动窗口（map）解决法：
     * 两个下标：i，j；一个集合set；一个最大值maxLength=0
     * 1、初始时i、j都指向第一个数
     * 2、array[j] 不存在map中，j++；如果maxLength<j-i+1,将j-i+1值赋给maxLength
     * 3、array[j] 存在集合中，如果位置比i大，和i+1交换
     * 4、array[j]加入map
     * <p>
     * 空间复杂度：O(n)
     * 最坏情况：n次，少了一半
     *
     * @param s
     * @return
     */
    @Override
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        Map<Character, Integer> characterMap = new HashMap<>(s.length());
        int i = 0;
        Integer idx;
        for (int j = 0; j < s.length(); j++) {
            Character character = s.charAt(j);
            idx = characterMap.get(character);
            if (idx != null && idx > i) {
                i = idx + 1;
            }
            characterMap.put(character, j);
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
            }
        }
        return maxLength;
    }


}
