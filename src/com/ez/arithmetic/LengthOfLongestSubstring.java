package com.ez.arithmetic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(solutionSlidingWindow("abcabcbb"));
    }

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
    public static int solutionSlidingWindow(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        int length  = s.length();
        Set<Character> set = new HashSet<>(length);
        int i = 0, j = 0;
        while (j < length) {
            Character character = s.charAt(j);
            while (set.contains(character)) {
                set.remove(s.charAt(i++));
            }
            set.add(new Character(character));
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
            }
            j++;
        }
        return maxLength;
    }

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
    public static int solutionSlidingWindowOptimize(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }
        int length  = s.length();
        Map<Character, Integer> map = new HashMap<>(length);
        int i = 0;
        Integer k;
        for (int j = 0; j < length; j++) {
            Character character = s.charAt(j);
            k = map.get(character);
            if (k != null && k >=i) {
                i = k + 1;
            }
            if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
            }
            map.put(character, j);
        }
        return maxLength;
    }
}
