package leetcode.linkedList;

/**
 * @program: first
 * @description: 两两交换链表中的结点
 * @author: panhao
 * @date: 2021-08-25 18:49
 **/
public class SwapPairs_n24 {
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

    public static ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode left= newHead;
        int k=2;
        int count=1;
        while (head!= null) {
            if (count==k){
                ListNode right=head;
                ListNode[] reverse = reverse(left.next, right);
                reverse[1].next=head.next;
                left.next=reverse[0];
                head=reverse[1];
                left=reverse[1];
                count=0;
            }
            count++;
            head=head.next;
        }
        return newHead.next;
    }
    public static ListNode[] reverse(ListNode head,ListNode tail) {
        ListNode newHead=new ListNode(tail.val);
        newHead.next=new ListNode(head.val);
        return new ListNode[]{newHead,newHead.next};
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println(swapPairs(n1));

    }
}
