package leetcode;

/**
 * @author panhao
 * @date 2021年05月05日 7:38 下午
 */
public class GetIntersectionNode_n160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena=0,lenb=0;
        ListNode tailA=headA,tailB=headB;
        while (tailA!=null){
            lena++;
            tailA=tailA.next;
        }
        while (tailB!=null){
            lenb++;
            tailB=tailB.next;
        }
        tailA=headA;
        tailB=headB;
        int diff;
        if (lena>lenb){
            diff=lena-lenb;
            for (int i=0;i<diff;i++){
                tailA=tailA.next;
            }
        }else{
            diff=lenb-lena;
            for (int i=0;i<diff;i++){
                tailB=tailB.next;
            }
        }
        for (;tailA!=tailB;){
            tailA=tailA.next;
            tailB=tailB.next;
        }
        if (tailA!=null) return tailA;
        return null;
    }
}
