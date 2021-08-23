package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 删除链表的倒数第N个结点
 * @author: panhao
 * @date: 2021-08-23 10:46
 **/
public class RemoveNthFromEnd_n19 {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumy = head;
        List<ListNode> list = new ArrayList<>();
        while (dumy != null) {
            list.add(dumy);
            dumy = dumy.next;
        }
        int len = list.size();
        if (len==1) {
            return null;
        }else if (len>1&&n==1) {
            list.get(len-n-1).next=null;
            return head;
        }else if (len==n) {
            return list.get(1);
        }else{
            list.get(len - n - 1).next = list.get(len - n + 1);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(removeNthFromEnd(n1,2));
    }
}
