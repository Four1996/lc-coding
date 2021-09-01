package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-01 15:24
 **/
public class MiddleNode_n876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            list.add(tail);
            tail = tail.next;
        }
        int len = list.size();
        int cur = len / 2;
        return list.get(cur);
    }
}
