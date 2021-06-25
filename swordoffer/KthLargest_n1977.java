package leetcode.swordoffer;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月04日 8:51 下午
 */
public class KthLargest_n1977 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    PriorityQueue<Integer> queue;
    public int kthLargest(TreeNode root, int k) {
        queue=new PriorityQueue<>();
        midOrder(root,k);
        return queue.poll();
    }
    void midOrder(TreeNode root,int k){
        if (root==null) return ;
        midOrder(root.right,k);
        if (queue.size()<k){
            queue.add(root.val);
        }else{
            return;
        }
        midOrder(root.left,k);
    }
}
