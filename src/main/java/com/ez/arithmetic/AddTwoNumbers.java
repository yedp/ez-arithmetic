package com.ez.arithmetic;

import java.util.List;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode rs = solutionSimple(l1, l2);
        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

    /**
     * 两个链表简单循环法
     * 同时循环两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solutionSimple(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int isIncr = 0;
        while (l1 != null || l2 != null || isIncr > 0) {
            int sum = isIncr;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum < 10) {
                p.next = new ListNode(sum);
                isIncr = 0;
            } else {
                p.next = new ListNode(sum % 10);
                isIncr = 1;
            }
            p = p.next;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
