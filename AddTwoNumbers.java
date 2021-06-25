package leetcode;
public class AddTwoNumbers {
    public class ListNode {//单链表的定义
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
//  1、  carry变量用于存储进位
//  2、 每次计算为l1val +l2val + carry;
//  3、 每次计算完成后注意将最后一个节点引用给cursor
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cursor = res;
        int carry = 0;//存储进位
        while(l1 !=null || l2 != null || carry !=0){
            int l1val = l1 !=null? l1.val:0;
            int l2val = l2 !=null? l2.val:0;
            int sum = l1val +l2val + carry;
            carry = sum/10;//通过本位的求和除以10获得下一位的进位。
            ListNode newNode = new ListNode(sum%10);
            cursor.next = newNode;
            cursor = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }
        return res.next;

    }


}
