package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-11 10:58
 **/
public class CanMerge_n5810 {
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

    public TreeNode canMerge(List<TreeNode> trees) {
        if (trees.size()==1) return trees.get(0);
        HashMap<Integer,TreeNode> map1 =new HashMap<>();
        HashMap<Integer,TreeNode> map2=new HashMap<>();
        for (TreeNode tree : trees) {
            map1.put(tree.val,tree);

        }

        for (Map.Entry<Integer, TreeNode> entry: map1.entrySet()){
            // Integer key = entry.getKey();
            TreeNode value = entry.getValue();
            if (value.left!=null){
                if (map2.containsKey(value.left.val)){
                    TreeNode treeNode = map2.get(value.left.val);
                    if (treeNode.right!=null){
                        if (treeNode.right.val<value.val) {
                            // value.left=treeNode;
                            // map1.put(key,value);
                            map2.remove(value.left.val);
                        }
                        else return null;
                    }else{
                        if (treeNode.val<value.val){
                            // value.left=treeNode;
                            // map1.put(key,value);
                            map1.remove(value.left.val);
                        }else return null;
                    }
                }
            }
        }
        return null;
    }
}
