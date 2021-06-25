package leetcode.classic;

import java.util.HashSet;

/**
 * @program: first
 * @description: 移除重复节点
 * @author: panhao
 * @date: 2021-06-22 21:11
 **/
public class RemoveDuplicateNodes_n2032 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        if (head==null) return null;
        ListNode pre=head;
        ListNode cur=pre.next;
        set.add(pre.val);
        while (cur!=null){
            if (set.contains(cur.val)){
                pre.next=cur.next;
            }else{
                set.add(cur.val);
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
