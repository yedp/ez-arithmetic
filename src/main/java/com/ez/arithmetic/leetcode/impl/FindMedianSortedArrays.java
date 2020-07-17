package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IFindMedianSortedArrays;

import java.util.Arrays;


public class FindMedianSortedArrays implements IFindMedianSortedArrays {
    /**
     * 合并数组,求合并数组的中位数
     * 时间复杂度O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    @Override
    public float solutionMidByMerge(int[] nums1, int[] nums2) {
        float result = 0;
        int[] numsAll = this.mergeArray(nums1, nums2);
        if (numsAll == null || numsAll.length == 0) {
            return result;
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
     * 合并两个数组
     *
     * @param a1
     * @param a2
     * @return
     */
    private int[] mergeArray(int[] a1, int[] a2) {
        if (a1 == null || a1.length == 0) {
            return a2;
        } else if (a2 == null || a2.length == 0) {
            return a1;
        }
        int[] numsAll = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                numsAll[k++] = a1[i++];
            } else {
                numsAll[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            numsAll[k++] = a1[i++];
        }
        while (j < a2.length) {
            numsAll[k++] = a2[j++];
        }
        return numsAll;
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
