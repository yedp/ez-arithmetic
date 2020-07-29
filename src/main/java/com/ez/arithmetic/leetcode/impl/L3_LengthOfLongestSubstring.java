package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL3_LengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L3_LengthOfLongestSubstring implements IL3_LengthOfLongestSubstring {

    @Override
    public int solutionSlidingWindow(String s) {
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

    @Override
    public int solutionSlidingWindowOptimize(String s) {
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
