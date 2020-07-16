package com.ez.arithmetic;

import java.util.Arrays;

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
public class FindMedianSortedArrays {

    public static void main(String args[]) {
        FindMedianSortedArrays sortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(sortedArrays.solutionMidByK(nums1, nums2));
    }

    /**
     * 合并数组,求合并数组的中位数
     * 时间复杂度O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static float solutionMid(int[] nums1, int[] nums2) {
        float result = 0;
        if (nums1 == null || nums2 == null) {
            return result;
        }
        int[] numsAll = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                numsAll[k++] = nums1[i++];
            } else {
                numsAll[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            numsAll[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            numsAll[k++] = nums2[j++];
        }
        if (numsAll.length % 2 == 0) {
            int idx1 = numsAll.length / 2 - 1;
            int idx2 = numsAll.length / 2;
            result = (float) ((numsAll[idx1] + numsAll[idx2]) / 2.0);
        } else {
            result = numsAll[numsAll.length / 2];
        }
        return result;
    }

    /**
     * 通过排除法，求第k大数：
     * 两数组合集为奇数时，k为中位数；
     * 两数组合集为偶数时，k为中位数；k k+1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public float solutionMidByK(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        //是否奇数
        boolean isOdd = len % 2 == 0 ? false : true;
        int k = (len + 1) / 2;
        return getK(nums1, nums2, k, isOdd);

    }

    /**
     * 两个数组第K大数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @param isOdd 如果不是奇数，获得K+1个数和K求平均
     * @return
     */
    private float getK(int[] nums1, int[] nums2, int k, boolean isOdd) {
        if (nums1 == null || nums1.length == 0) {
            return getK(nums2, k, isOdd);
        }
        if (nums2 == null || nums2.length == 0) {
            return getK(nums1, k, isOdd);
        }
        if (k == 1) {

            if (isOdd) {
                return nums1[0] < nums2[0] ? nums1[0] : nums2[0];
            } else {
                float k1Value = 0;
                float k2Value = 0;
                if (nums1[0] < nums2[0]) {
                    k1Value = nums1[0];
                    if (nums1.length >= 2) {
                        k2Value = nums1[1] < nums2[0] ? nums1[1] : nums2[0];
                    } else {
                        k2Value = nums2[0];
                    }
                } else {
                    k1Value = nums2[0];
                    if (nums2.length >= 2) {
                        k2Value = nums1[0] < nums2[1] ? nums1[0] : nums2[1];
                    } else {
                        k2Value = nums1[0];
                    }
                }
                return (k1Value + k2Value) / 2f;
            }

        }
        int midK = k / 2;
        int i = nums1.length < midK ? nums1.length : midK;
        int j = nums2.length < midK ? nums2.length : midK;
        if (nums1[i - 1] < nums2[j - 1]) {
            return getK(Arrays.copyOfRange(nums1, i, nums1.length), nums2, k - i, isOdd);
        } else {
            return getK(nums1, Arrays.copyOfRange(nums2, j, nums2.length), k - j, isOdd);
        }
    }

    private float getK(int[] nums, int k, boolean isOdd) {
        if (isOdd) {
            return nums[k - 1];
        } else {
            return (nums[k - 1] + nums[k]) / 2f;
        }
    }
}
