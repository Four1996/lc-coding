package leetcode.classic;

/**
 * @program: first
 * @description: 链表求和
 * @author: panhao
 * @date: 2021-06-22 22:33
 **/
public class AddTwoNumbers_n2036 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (tail1 != null && tail2 != null) {
            int num = tail1.val + tail2.val;
            if (c > 0) {
                num++;
                c--;
            }
            tail.next = new ListNode(num % 10);
            tail = tail.next;
            c += num / 10;
            tail1=tail1.next;
            tail2=tail2.next;
        }
        while (tail1 != null) {
            int num = tail1.val;
            if (c > 0) {
                num++;
                c--;
            }
            tail.next = new ListNode(num%10);
            tail=tail.next;
            c += num / 10;
            tail1=tail1.next;
        }
        while (tail2!=null){
            int num=tail2.val;
            if (c>0){
                num++;
                c--;
            }
            tail.next=new ListNode(num%10);
            tail=tail.next;
            c+=num/10;
            tail2=tail2.next;
        }
        if (c>0) {
            tail.next=new ListNode(c);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode b1=new ListNode(9);
        ListNode b2=new ListNode(9);
        b1.next=b2;
        System.out.println(addTwoNumbers(a1,b1));
    }
}
