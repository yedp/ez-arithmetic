package com.ez.arithmetic;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target1 = 17;
        int[] rs1 = {7, 8};
//        int[] rs = simpleSolution(nums1, target1);
        int[] rs = hashSolution(nums1,target1);
        System.out.println(rs[0] + ";" + rs[1]);
    }

    /**
     * 方法一：暴力破解法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] simpleSolution(int[] nums, int target) {
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

    /**
     * hash方式解决
     * @param nums
     * @param target
     * @return
     */
    public static int[] hashSolution(int[] nums, int target) {
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
            numHash.put(nums[i],i);
        }
        return rs;
    }


}
