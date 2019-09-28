package com.yhyr.Algorithm;

import com.yhyr.Model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yhyr
 * @since 2019/09/28 23:47
 */
public class Q141_NodeHasCycle {
    /**
     * Hash法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针法
     *
     * 双指针可行性证明：假设慢指针刚进入圆环时，快指针在慢指针前的距离为m；圆环的长度为n
     *
     * 设慢指针速度为1，快指针的速度是其的x倍；假设快慢能相遇，则相遇时耗时为T，则：xT - 1T = n - m
     *
     * 如果快指针速度是慢指针两倍，则T = n - m；公式恒成立，代表的含义是：当慢指针刚进入圆环后，慢指针再走n-m步，就可以和快指针相遇，
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }
}
