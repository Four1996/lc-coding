package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 7:59 下午
 */
public class GetIntersectionNode_n1974 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1=headA,node2=headB;
        while (node1!=node2){
            node1=node1!=null?node1.next:headB;
            node2=node2!=null?node2.next:headA;
        }
        return node1;
    }
}
