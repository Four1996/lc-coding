package leetcode.linkedList;

import java.util.List;

/**
 * @program: first
 * @description: 回文链表
 * @author: panhao
 * @date: 2021-09-01 15:45
 **/
public class IsPalindrome_n2131 {
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

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = null, temp;
        // 如果长度为偶数，fast正好为空，slow指向第二个中间节点
        // 如果为奇数，fast正好指向末尾。slow指向中间节点。
        while (fast != null && fast.next != null) {
            if (pre == null) {
                pre = new ListNode(slow.val);
            } else {
                temp = new ListNode(slow.val);
                temp.next = pre;
                pre = temp;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
