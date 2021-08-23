package leetcode.simulate;

import java.util.List;

/**
 * @program: first
 * @description: K个一组翻转链表
 * @author: panhao
 * @date: 2021-08-23 09:38
 **/
public class ReverseKGroup_n25 {
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        head = newHead;
        int idx = 0;
        ListNode tail = head;
        ListNode left = tail;
        while (tail.next != null) {
            tail = tail.next;
            idx++;
            if (idx == k) {
                ListNode temp=tail.next;
                ListNode[] reverse = reverse(left.next,k);
                reverse[1].next = temp;
                left.next = reverse[0];
                left=reverse[1];
                idx = 0;
                tail=reverse[1];
            }
        }
        return newHead.next;
    }
    public static ListNode[] reverse(ListNode head,int k) {
        ListNode newTail=head;
        ListNode newHead=head;
        int count=1;
        head=head.next;
        while (count<k) {
            ListNode node=new ListNode(head.val);
            node.next=newHead;
            newHead=node;
            head = head.next;
            count++;
        }
        newTail.next=null;
        return new ListNode[]{newHead, newTail};
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(reverseKGroup(n1, 2));
    }
}
