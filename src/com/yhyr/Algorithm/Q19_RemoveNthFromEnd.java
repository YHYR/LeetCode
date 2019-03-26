package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。给定的n保证是有效的; 即n <= len(链表)
 * <p>
 * 通过双指针 实现O(n)复杂度内的删除操作；同时基于双指针的距离实现删除任意位置的节点
 * => 如果n 大于链表长度；返回原链表的头节点
 *
 * @author yhyr
 * @since 2019/3/25 0025 16:04
 */
public class Q19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        if (head.next == null) {
            if (n == 0) {
                return head;
            } else {
                return null;
            }
        }
        ListNode right = left;
        int step = 1;

        while (right.next != null) {
            if (step <= n) {
                right = right.next;
                step += 1;
            } else {
                right = right.next;
                left = left.next;
            }
        }

        if (n < step) {
            left.next = left.next.next;
        }
        if (n == step) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Q19_RemoveNthFromEnd action = new Q19_RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);

        node_4.next = null;
        node_3.next = node_4;
        node_2.next = node_3;
        node_1.next = node_2;
        head.next = node_1;

        action.removeNthFromEnd(head, 7);
    }
}
