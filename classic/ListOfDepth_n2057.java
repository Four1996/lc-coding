package leetcode.classic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 特定深度节点链表
 * @author: panhao
 * @date: 2021-06-28 11:03
 **/
public class ListOfDepth_n2057 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode[] listOfDepth(TreeNode tree) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        if (tree!=null) deque.addFirst(tree);
        List<ListNode> list=new ArrayList<>();
        while (!deque.isEmpty()){
            int size=deque.size();
            ListNode listNode=null;
            ListNode tail=null;
            for (int i=0;i<size;i++){
                TreeNode treeNode=deque.pollLast();
                if (treeNode.left!=null) deque.addFirst(treeNode.left);
                if (treeNode.right!=null) deque.addFirst(treeNode.right);
                if (listNode==null) listNode=tail=new ListNode(treeNode.val);
                else{
                    tail.next=new ListNode(treeNode.val);
                    tail=tail.next;
                }
            }
            list.add(listNode);
        }
        ListNode[] ans=new ListNode[list.size()];
        int idx=0;
        for (ListNode listNode : list) {
            ans[idx++]=listNode;
        }
        return ans;
    }
}
