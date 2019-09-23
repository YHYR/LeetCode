package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject: 反转单链表
 *
 * @author yhyr
 * @since 2019/09/23 23:08
 */
public class Q206_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode currNode = head;
        ListNode nextNode = currNode.next;
        while (nextNode != null) {
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
            nextNode = currNode.next;
        }
        currNode.next = preNode;
        return currNode;
    }

    public static void main(String[] args) {
        Q206_ReverseList action = new Q206_ReverseList();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode reverseNode = action.reverseList(head);
    }
}
