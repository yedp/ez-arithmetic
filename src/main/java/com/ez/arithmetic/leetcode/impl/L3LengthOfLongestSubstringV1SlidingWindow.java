package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL3LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author daoping.ye
 * @Date 2020/7/29 14:49
 * @Desc
 */
public class L3LengthOfLongestSubstringV1SlidingWindow implements IL3LengthOfLongestSubstring {

    /**
     * 滑动窗口（集合）解决法：
     * 两个下标：i，j；一个集合set；一个最大值maxLength=0
     * 1、初始时i、j都指向第一个数
     * 2、array[j] 不存在set中，j++；如果maxLength<j-i+1,将j-i+1值赋给maxLength
     * 3、array[j] 存在集合中，移除array[i],i++
     * 4、重复3，直至集合中没有array[j]相等字符
     * 5、array[j]加入集合
     * <p>
     * 时间复杂度：O（n）
     * 最坏情况：2n次
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
        Set<Character> characterSet = new HashSet<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            Character character = s.charAt(j);
            while (characterSet.contains(character)) {
                characterSet.remove(s.charAt(i++));
            }
            characterSet.add(character);
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
            }
        }
        return maxLength;
    }

}
