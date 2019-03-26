package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author yhyr
 * @since 2019/3/26 0026 21:45
 */
public class Q24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode indexNode = head;
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            indexNode = head.next;
            head.next = head.next.next;
            indexNode.next = head;
            head = indexNode;
            indexNode = indexNode.next;
        }
        ListNode temp;
        while (indexNode.next != null && indexNode.next.next != null) {
            temp = indexNode.next;
            indexNode.next = temp.next;
            temp.next = indexNode.next.next;
            indexNode.next.next = temp;
            indexNode = indexNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Q24_SwapPairs action = new Q24_SwapPairs();
        ListNode head = new ListNode(1);
        ListNode node_1 = new ListNode(2);
        ListNode node_2 = new ListNode(3);
        ListNode node_3 = new ListNode(4);
        ListNode node_4 = new ListNode(5);
        ListNode node_5 = new ListNode(6);

        node_5.next = null;
        node_4.next = node_5;
        node_3.next = node_4;
        node_2.next = node_3;
        node_1.next = node_2;
        head.next = node_1;
        action.swapPairs(head);
    }
}
