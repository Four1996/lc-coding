package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年04月05日 10:40 上午
 */
public class PostOrderTraveral_2_n145 {
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
    List<Integer> list=new ArrayList<>();
    Stack<TreeNode> st=new Stack<>();
    public List<Integer> posterOrderTraveral(TreeNode root){
        TreeNode t= root;
        TreeNode r=null;
        if (t==null) return new ArrayList<>();
        st.push(t);
        t=t.left;
        while(t!=null||!st.isEmpty()){
                if (t!=null){
                    st.push(t);
                    t=t.left;
                }
                else{
                    t=st.peek();
                    if (t.right!=null&&r!=t.right){
                        t=t.right;
                    }else{
                        r=st.pop();
                        list.add(r.val);
                        t=null;
                    }
                }


        }
        return list;
    }
}
