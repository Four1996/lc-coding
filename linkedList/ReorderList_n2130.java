package leetcode.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 重排链表
 * @author: panhao
 * @date: 2021-09-01 14:54
 **/
public class ReorderList_n2130 {
    public static class ListNode {
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

    public static void reorderList(ListNode head) {
        ListNode tail=head;
        Deque<ListNode> deque=new ArrayDeque<>();
        int count=0;
        while (tail!=null){
            deque.addFirst(tail);
            count++;
            tail=tail.next;
        }
        tail=head;
        count/=2;
        while (!deque.isEmpty()&&count>0){
            int num=deque.pollFirst().val;
            count--;
            if (!deque.isEmpty()){
                deque.peekFirst().next=null;
            }
            ListNode node=new ListNode(num);
            node.next=tail.next;
            tail.next=node;
            tail=node.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        reorderList(n1);
    }
}
