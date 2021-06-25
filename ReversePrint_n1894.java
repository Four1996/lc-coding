package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月08日 10:34 上午
 */
public class ReversePrint_n1894 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    Stack<Integer> s = new Stack<>();

    public int[] reversePrint(ListNode head) {
        while (head!=null){
            s.push(head.val);
            head=head.next;
        }
        int[] ans=new int[s.size()];
        int i=0;
        while (!s.isEmpty()){
            ans[i]=s.pop();
            i++;
        }
        return ans;
    }

}
