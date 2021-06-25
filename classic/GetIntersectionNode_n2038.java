package leetcode.classic;

/**
 * @program: first
 * @description: 链表相交
 * @author: panhao
 * @date: 2021-06-23 09:56
 **/
public class GetIntersectionNode_n2038 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail1=headA;
        ListNode tail2=headB;
        while (tail1!=tail2){
            tail1=tail1==null?headB:tail1.next;
            tail2=tail2==null?headA:tail2.next;
        }
        return tail1;
    }
}
