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

    @Override
    public float solutionMidByTopK(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        //奇数中位数（偶数中位第一位）
        int mid1 = (len + 1) / 2;
        //中位偶数第二位（如果是奇数则是中位数）
        int mid2 = (len + 2) / 2;
        float mid1Value = getK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, mid1);
        float mid2Value = getK(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, mid2);
        return (mid1Value + mid2Value) / 2;

    }

    /**
     * 获取两个有序数组第K大数据
     *
     * @param nums1
     * @param start1
     * @param end1
     * @param nums2
     * @param start2
     * @param end2
     * @param k
     * @return
     */
    private float getK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (len2 == 0) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getK(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getK(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
