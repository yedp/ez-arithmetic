package com.ez.arithmetic.leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public interface IFindMedianSortedArrays {
    /**
     * 方法1：通过合并两个数组求中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    float solutionMidByMerge(int[] nums1, int[] nums2);

    /**
     *   过排除法，求第k大数：
     *   两数组合集为奇数时，k为中位数；
     *   两数组合集为偶数时，k为中位数；k k+1
     * @param nums1
     * @param nums2
     * @return
     */
    float solutionMidByTopK(int[] nums1, int[] nums2);

    /**
     * 从中间常规解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    float solutionMidNormal(int nums1[], int[] nums2);
}
