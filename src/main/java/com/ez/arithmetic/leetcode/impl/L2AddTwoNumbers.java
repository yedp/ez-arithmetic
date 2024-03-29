package com.ez.arithmetic.leetcode.impl;

import com.ez.arithmetic.leetcode.IL2AddTwoNumbers;
import com.ez.arithmetic.leetcode.common.ListNode;
/**
 * @Author  daoping.ye
 * @Date    2020/7/29 14:52
 * @Desc    
 */
public class L2AddTwoNumbers implements IL2AddTwoNumbers {
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int isIncr = 0;
        while (l1 != null || l2 != null || isIncr > 0) {
            int sum = isIncr;
            if (l1 != null) {
                sum += l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                sum += l2.getVal();
                l2 = l2.getNext();
            }
            if (sum < 10) {
                p.setNext(new ListNode(sum));
                isIncr = 0;
            } else {
                p.setNext(new ListNode(sum % 10));
                isIncr = 1;
            }
            p = p.getNext();
        }
        return head.getNext();
    }
}
