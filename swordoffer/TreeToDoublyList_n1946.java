package leetcode.swordoffer;

import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月25日 10:38 上午
 */
public class TreeToDoublyList_n1946 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node head,pre;
    public Node treeToDoublyList(Node root) {
      if (root==null) return null;
      midOrder(root);
      head.left=pre;
      pre.right=head;
      return head;
    }
    void midOrder(Node cur){
        if (cur==null) return;
        midOrder(cur.left);
        if (pre!=null) pre.right=cur;
        else head=cur;
        cur.left=pre;
        pre=cur;
        midOrder(cur.right);
    }
}
