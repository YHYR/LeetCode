package com.yhyr.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * Tip: 需要考虑直接相加求和溢出的情况
 *
 * @author yhyr
 * @since 2019/01/04 15:52
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> r1 = new ArrayList<>();
        parseListNode(l1, r1);

        List<Integer> r2 = new ArrayList<>();
        parseListNode(l2, r2);

        formatResultList(r1, r2);

        List<Integer> resultList = new ArrayList<>();
        customAdd(resultList, r1, r2);

        ListNode listNode = new ListNode(resultList.get(0));
        buildListNode(listNode, resultList, 1);
        return listNode;
    }

    private void customAdd(List<Integer> resultList, List<Integer> l1, List<Integer> l2) {
        int bit = 0;
        for (int i = 0; i < l1.size(); i++) {
            int sum = l1.get(i) + l2.get(i) + bit;
            resultList.add(sum % 10);
            bit = sum / 10;
        }
        if (bit > 0) {
            resultList.add(bit);
        }
    }

    private void formatResultList(List<Integer> l1, List<Integer> l2) {
        int diffValue = l1.size() - l2.size();
        for (int i = 0; i < Math.abs(diffValue); i++) {
            if (diffValue > 0) {
                l2.add(0);
            } else {
                l1.add(0);
            }
        }
    }

    private void buildListNode(ListNode listNode, List<Integer> resultList, int index) {
        if (index < resultList.size()) {
            ListNode node = new ListNode(resultList.get(index));
            listNode.next = node;
            buildListNode(node, resultList, ++index);
        }
    }

    private void parseListNode(ListNode listNode, List<Integer> result) {
        result.add(listNode.val);
        if (listNode.next != null) {
            parseListNode(listNode.next, result);
        }
    }

    public static void main(String[] args) {
        Q2_AddTwoNumbers action = new Q2_AddTwoNumbers();

        ListNode node1 = new ListNode(9);

        ListNode node2 = new ListNode(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        list.add(9);
        action.buildListNode(node2, list, 1);

        action.addTwoNumbers(node1, node2);
    }
}
