package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

import java.util.Arrays;

/**
 * Subject: 合并K个有序链表
 * 
 * @author yhyr
 * @since 2019/09/24 22:48
 */
public class Q23_MergeKListNode {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode currNode = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                currNode.next = node1;
                currNode = node1;
                node1 = node1.next;
            } else {
                currNode.next = node2;
                currNode = node2;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            currNode.next = node1;
        }
        if (node2 != null) {
            currNode.next = node2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Q23_MergeKListNode action = new Q23_MergeKListNode();
        ListNode node_A = new ListNode(1);
        ListNode node_A2 = new ListNode(2);
        ListNode node_A3 = new ListNode(4);
        node_A.next = node_A2;
        node_A2.next = node_A3;

        ListNode node_B = new ListNode(0);
        ListNode node_B2 = new ListNode(2);
        ListNode node_B3 = new ListNode(3);
        ListNode node_B4 = new ListNode(5);
        node_B.next = node_B2;
        node_B2.next = node_B3;
        node_B3.next = node_B4;

        ListNode[] listNodes = {node_A, node_B};
        ListNode result = action.mergeKLists(listNodes);
    }
}
