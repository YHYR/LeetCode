package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject: 排序链表
 * 
 * @author yhyr
 * @since 2019/09/29 21:18
 */
public class Q148_SortNodeList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        head = head.next;
        start.next.next = null;
        ListNode pre;
        ListNode cur;
        while (head != null) {
            pre = start;
            cur = start.next;
            while (cur != null) {
                if (cur.val >= head.val) {
                    pre.next = head;
                    head = head.next;
                    pre.next.next = cur;
                    cur = pre.next;
                    break;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            if (cur == null) {
                pre.next = head;
                head = head.next;
                pre.next.next = null;
            }
        }
        return start.next;
    }

    public static void main(String[] args) {
        Q148_SortNodeList action = new Q148_SortNodeList();
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-1);
        ListNode node5 = new ListNode(0);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = action.sortList(head);
    }
}
