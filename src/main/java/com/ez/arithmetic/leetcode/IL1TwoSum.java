package com.ez.arithmetic.leetcode;

/**
 * @author daoping.ye
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 通过次数1,012,342提交次数2,097,797
 * <p>
 */
public interface IL1TwoSum {
//    /**
//     * 方法一：暴力破解法
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    int[] exhaustSolution(int[] nums, int target);
//
//    /**
//     * 方法二：hash方式解决
//     *
//     * @param nums
//     * @param target
//     * @return
//     */
//    int[] hashSolution(int[] nums, int target);

    int[] twoSum(int[] nums, int target);

}
