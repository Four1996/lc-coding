package leetcode.classic;

/**
 * @program: first
 * @description: 删除中间节点
 * @author: panhao
 * @date: 2021-06-22 21:26
 **/
public class DeleteNode_n2034 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
