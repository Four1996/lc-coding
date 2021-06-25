package leetcode;

import java.util.Scanner;

/**
 * @author panhao
 * @date 2021年04月12日 9:23 下午
 */
public class MergeTwoLists {
    static class ListNode {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null) return l2==null?l1:l2;
        if (l1==null&&l2==null) return null;
        ListNode head=null;
        ListNode tail1=l1;
        ListNode tail2=l2;
        ListNode tail=null;
        for (;tail1!=null&&tail2!=null;){
            if (tail1.val<tail2.val){
                ListNode node=new ListNode(tail1.val);
                if (head==null) head=tail=node;
                tail.next=node;
                tail=tail.next;
                tail1=tail1.next;
            }else{
                ListNode node=new ListNode(tail2.val);
                if (head==null) head=tail=node;
                tail.next=node;
                tail2=tail2.next;
                tail=tail.next;
            }
        }
        if (tail1==null){
            tail.next=tail2;

        }else{
            tail.next=tail1;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        RotateRight.ListNode head=null;
        RotateRight.ListNode tail=null;
        while (n!=-1){
            RotateRight.ListNode newnode=new RotateRight.ListNode(n);
            if (head==null) head=tail=newnode;
            else{
                tail.next=newnode;
                tail=newnode;
            }
            n=input.nextInt();
        }
    }
}
