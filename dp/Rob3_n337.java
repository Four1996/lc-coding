package leetcode.dp;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年06月14日 2:47 下午
 */
public class Rob3_n337 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map=new HashMap<>();
        return getMax(root,map);
    }
    public int getMax(TreeNode root,HashMap<TreeNode,Integer> map){
        if (root==null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int money=root.val;
        if (root.left!=null){
            money+=getMax(root.left.left,map)+getMax(root.left.right,map);
        }
        if (root.right!=null){
            money+=getMax(root.right.left,map)+getMax(root.right.right,map);
        }
        int res=Math.max(money,getMax(root.left,map)+getMax(root.right,map));
        map.put(root,res);
        return res;
    }
}
