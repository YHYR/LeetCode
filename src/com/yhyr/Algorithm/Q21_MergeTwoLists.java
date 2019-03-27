package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * @author yhyr
 * @since 2019/3/25 0025 11:25
 */

public class Q21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode indexNode = l1;
        if (l1.val > l2.val) {
            l1 = l2;
            l2 = indexNode;
            indexNode = l1;
        }
        while (indexNode.next != null && l2 != null) {
            if (indexNode.val < l2.val && indexNode.next.val < l2.val) {
                indexNode = indexNode.next;
            } else {
                ListNode temp2 = l2.next;
                l2.next = indexNode.next;
                indexNode.next = l2;
                l2 = temp2;
                indexNode = indexNode.next;
            }
        }
        if (indexNode.next == null) {
            indexNode.next = l2;
        }
        return l1;
    }

    public static void main(String[] args) {
        Q21_MergeTwoLists action = new Q21_MergeTwoLists();
        ListNode l1 = new ListNode(0);
        ListNode l1_2 = new ListNode(1);
        ListNode l1_3 = new ListNode(2);
        l1_3.next = null;
        l1_2.next = l1_3;
        l1.next = l1_2;

        ListNode l2 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_3.next = null;
        l2_2.next = l2_3;
        l2.next = l2_2;
        action.mergeTwoLists(l1, l2);
    }
}
