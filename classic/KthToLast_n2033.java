package leetcode.classic;

/**
 * @program: first
 * @description: 返回倒数第k个节点
 * @author: panhao
 * @date: 2021-06-22 21:17
 **/
public class KthToLast_n2033 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        int len=0;
        ListNode dumy=head;
        while (dumy!=null){
            len++;
            dumy=dumy.next;
        }
        int count=0;
        dumy=head;
        while (dumy!=null){
            count++;
            if (len-count+1==k) return dumy.val;
            dumy=dumy.next;
        }
        return 0;
    }
}
