package leetcode.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月31日 7:41 下午
 */
public class GenerateTrees_n95 {
    public static   class TreeNode {
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

    public static List<TreeNode> generateTrees(int n) {
        if (n==0) return new LinkedList<TreeNode>();
        return generate(1,n);
    }
    public static List<TreeNode> generate(int start, int end){
        List<TreeNode> allTrees=new LinkedList<>();
        if (start>end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree=generate(start,i-1);
            List<TreeNode> rightTree=generate(i+1,end);
            for (TreeNode left: leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
