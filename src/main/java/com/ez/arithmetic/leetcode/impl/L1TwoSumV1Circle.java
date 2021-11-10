package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL1TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一种解，最容易想到的，循环遍历
 *
 * @Author daoping.ye
 * @Date 2020/7/29 14:49
 * @Desc
 */
public class L1TwoSumV1Circle implements IL1TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
