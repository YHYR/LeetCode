package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject: 找到两个单链表相交的起始节点
 * 
 * @author yhyr
 * @since 2019/09/29 0:45
 */
public class Q160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null) {
            if (set.contains(nodeA)) {
                return nodeA;
            }
            set.add(nodeA);
            nodeA = nodeA.next;
            if (set.contains(nodeB)) {
                return nodeB;
            }
            set.add(nodeB);
            nodeB = nodeB.next;
        }
        while (nodeA != null) {
            if (set.contains(nodeA)) {
                return nodeA;
            }
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            if (set.contains(nodeB)) {
                return nodeB;
            }
            set.add(nodeB);
            nodeB = nodeB.next;
        }
        return null;
    }
}
