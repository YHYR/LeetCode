package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * Subject：给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 解题思路：基于双指针来确定链表尾部节点、倒数第K个节点和倒数第K+1个节点；然后用尾部拼接头部即可
 * @author yhyr
 * @since 2019/09/28 11:07
 */
public class Q61_RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 特殊情况处理
        if (head == null || k == 0) {
            return head;
        }
        ListNode preNode;
        ListNode curNode = head;
        ListNode fastNode = head;
        int step = k;
        while (step > 0) {
            fastNode = fastNode.next;
            step--;
            if (fastNode == null) {
                if (step == 0) {
                    return head;
                }
                int nodeLength = k - step;
                // 过滤链表长度整倍数的步长，减少无效遍历
                while (step > nodeLength) {
                    step = step - nodeLength;
                }
                fastNode = head;
            }
        }
        while (fastNode.next != null) {
            curNode = curNode.next;
            fastNode = fastNode.next;
        }
        preNode = curNode;
        curNode = curNode.next;
        preNode.next = null;
        fastNode.next = head;
        return curNode;
    }

    public static void main(String[] args) {
        Q61_RotateRight action = new Q61_RotateRight();
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = action.rotateRight(head, 6);

    }
}
