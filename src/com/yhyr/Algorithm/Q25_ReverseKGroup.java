package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;


/**
 * Subject
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * @author yhyr
 * @since 2019/3/27 0027 14:50
 */
public class Q25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }
        ListNode indexNode = reverse(head, k);
        if (indexNode == null) {
            return head;
        }
        head = indexNode;
        for (int i = 0; i < k - 1; i++) {
            indexNode = indexNode.next;
        }

        while (indexNode != null) {
            ListNode result = reverse(indexNode.next, k);
            if (result == null) {
                break;
            } else {
                indexNode.next = result;
            }
            for (int i = 0; i < k; i++) {
                indexNode = indexNode.next;
            }
        }
        return head;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        ListNode node = head;
        int index = 0;
        while (index < k && node != null) {
            listNodes[index] = node;
            node = node.next;
            index += 1;
        }
        if (index < k) {
            return null;
        }

        listNodes[0].next = listNodes[k - 1].next;
        for (int i = 1; i < k; i++) {
            listNodes[i].next = listNodes[i - 1];
        }
        return listNodes[k - 1];
    }

    public static void main(String[] args) {
        Q25_ReverseKGroup action = new Q25_ReverseKGroup();
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

        action.reverseKGroup(head, 0);
    }
}
