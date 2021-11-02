package leetcode.linkedList;

/**
 * @program: first
 * @description: 删除链表中的节点
 * @author: panhao
 * @date: 2021-11-02 10:21
 **/
public class deleteNode_n237 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public void deleteNode(ListNode node){
      node.val=node.next.val;
      node.next=node.next.next;
    }
}
