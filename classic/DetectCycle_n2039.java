package leetcode.classic;

import java.util.HashSet;

/**
 * @program: first
 * @description: 环路检测
 * @author: panhao
 * @date: 2021-06-23 10:27
 **/
public class DetectCycle_n2039 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }
}
