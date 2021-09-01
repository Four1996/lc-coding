package leetcode.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 链表中的两数相加
 * @author: panhao
 * @date: 2021-09-01 10:58
 **/
public class AddTwoNumbers_n2129 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail1 = l1, tail2 = l2;
        Deque<ListNode> deque1 = new ArrayDeque<>();
        Deque<ListNode> deque2 = new ArrayDeque<>();
        while (tail1 != null) {
            deque1.addFirst(tail1);
            tail1 = tail1.next;
        }
        while (tail2 != null) {
            deque2.addFirst(tail2);
            tail2 = tail2.next;
        }
        ListNode newHead = null;
        int c = 0;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            ListNode node1 = deque1.pollFirst();
            ListNode node2 = deque2.pollFirst();
            int val = node1.val + node2.val + c;
            c = val / 10;
            val %= 10;
            ListNode node = new ListNode(val);
            if (newHead == null) {
                newHead = node;
            } else {
                node.next = newHead;
                newHead = node;
            }
        }
        while (!deque1.isEmpty()){
            ListNode poll=deque1.pollFirst();
            int num=poll.val+c;
            c=num/10;
            num%=10;
            ListNode node=new ListNode(num);
            if (newHead == null) {
                newHead = node;
            } else {
                node.next = newHead;
                newHead = node;
            }
        }
        while (!deque2.isEmpty()){
            ListNode poll=deque2.pollFirst();
            int num=poll.val+c;
            c=num/10;
            num%=10;
            ListNode node=new ListNode(num);
            if (newHead == null) {
                newHead = node;
            } else {
                node.next = newHead;
                newHead = node;
            }
        }
        if (c>0){
            ListNode node=new ListNode(c);
            node.next=newHead;
            newHead=node;
        }
        return newHead;
    }
}
