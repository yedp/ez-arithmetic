package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL1_TwoSum;

import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum implements IL1_TwoSum {
    @Override
    public int[] exhaustSolution(int[] nums, int target) {
        int[] rs = null;
        if (nums == null) {
            return rs;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    rs = new int[]{i, j};
                }
            }
        }
        return rs;
    }

    @Override
    public int[] hashSolution(int[] nums, int target) {
        int[] rs = null;
        if (nums == null) {
            return rs;
        }
        Map<Integer, Integer> numHash = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = numHash.get(target - nums[i]);
            if (j != null) {
                rs = new int[]{i, j};
                break;
            }
            numHash.put(nums[i], i);
        }
        return rs;
    }
}
