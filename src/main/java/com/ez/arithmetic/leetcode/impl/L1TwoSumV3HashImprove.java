package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL1TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 第三种解法，hash方式改进，只需要遍历一次
 *
 * @Author daoping.ye
 * @Date 2020/7/29 14:49
 * @Desc
 */
public class L1TwoSumV3HashImprove implements IL1TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer idx2 = map.get(target - nums[i]);
            if (idx2 != null && idx2 != i) {
                return new int[]{i, idx2};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
