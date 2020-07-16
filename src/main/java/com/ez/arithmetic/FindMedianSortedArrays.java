package com.ez.arithmetic;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    public static void main(String args[]){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solutionMid(nums1,nums2));
    }

    /**
     * 合并数组,求合并数组的中位数
     * 时间复杂度O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static float solutionMid(int[] nums1, int[] nums2){
        float result = 0;
        if(nums1 == null || nums2 == null){
            return result;
        }
        int[] numsAll = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j]){
                numsAll[k++] = nums1[i++];
            }else {
                numsAll[k++] = nums2[j++];
            }
        }
        while (i<nums1.length ){
            numsAll[k++] = nums1[i++];
        }
        while (j<nums2.length ){
            numsAll[k++] = nums2[j++];
        }

        if(numsAll.length % 2 == 0){
            int idx1 = numsAll.length/2-1;
            int idx2 = numsAll.length/2;
            result = (float) ((numsAll[idx1] + numsAll[idx2])/2.0);
        }else {
            result = numsAll[numsAll.length/2];
        }
        return result;
    }

    // NLogN算法：求第k大数

}
