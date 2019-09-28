package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Subject: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author yhyr
 * @since 2019/09/29 0:32
 */
public class Q142_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new LinkedHashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
