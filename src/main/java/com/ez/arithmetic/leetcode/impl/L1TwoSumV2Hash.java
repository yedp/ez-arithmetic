package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL1TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 第二种解，通过hash方法解决，只需要遍历两次
 *
 * @Author daoping.ye
 * @Date 2020/7/29 14:49
 * @Desc
 */
public class L1TwoSumV2Hash implements IL1TwoSum {

    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer value = target - nums[i];
            Integer idx2 = map.get(value);
            if (idx2 != null && idx2 != i) {
                return new int[]{i, idx2};
            }
        }
        return new int[0];
    }
}
