package leetcode;

import java.util.Scanner;

public class RotateRight {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode rotateRight(ListNode head,int k){//总体思路：先将所有元素存在数组中，然后通过遍历数组用先尾插再头插得到新链表。
        ListNode tail=new ListNode();
        ListNode dummy=null;

        if(head==null) return null;
        if (head.next==null||k==0) return head;
        tail=head;//指向链表头部
        int len=0;
        while(head!=null){//获得链表长度
            head=head.next;
            len++;
        }
        int num_slid=k%len;
        int[] nums=new int[len];
        for (int i=0;i<len;i++){//将链表元素全部存在数组中
            nums[i]=tail.val;
            tail=tail.next;
        }
        ListNode sliding_1=new ListNode();
        ListNode sliding_2=null;
        for(int i=0;i<len-num_slid;i++){
            ListNode newnode=new ListNode(nums[i]);
            if (dummy==null) dummy=sliding_1=newnode;
            else{
                sliding_1.next=newnode;
                sliding_1=newnode;
            }
        }
        sliding_2=dummy;
        for(int i=len-1;i>=len-num_slid;i--){
            ListNode newnode=new ListNode(nums[i]);

            dummy=newnode;
            dummy.next=sliding_2;
            sliding_2=dummy;
        }
        return dummy;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        ListNode head=null;
        ListNode tail=null;
        while (n!=-1){
            ListNode newnode=new ListNode(n);
            if (head==null) head=tail=newnode;
            else{
                tail.next=newnode;
                tail=newnode;
            }
            n=input.nextInt();
        }
        rotateRight(head,4);
    }
}
