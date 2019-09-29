package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

/**
 * @author yhyr
 * @since 2019/09/30 0:39
 */
public class Q237_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
