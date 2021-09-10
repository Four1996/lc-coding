package leetcode.preTree;

/**
 * @program: first
 * @description: 最大的异或
 * @author: panhao
 * @date: 2021-09-10 20:10
 **/
public class findMaximumXOR_n2181 {
    class TreeNode {
        TreeNode[] tn = new TreeNode[2];
    }

    TreeNode root;

    public findMaximumXOR_n2181() {
        root = new TreeNode();
    }

    public void insert(int x) {
        TreeNode p = root;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.tn[u] == null) {
                p.tn[u] = new TreeNode();
            }
            p = p.tn[u];
        }
    }

    public int getVal(int x) {
        int ans = 0;
        TreeNode p = root;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1;
            int b = 1 - a;
            if (p.tn[b] != null) {
                ans |= (b << i);
                p = p.tn[b];
            } else {
                ans |= (a << i);
                p = p.tn[a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            insert(num);
            int temp = getVal(num);
            ans = Math.max(ans, num ^ temp);
        }
        return ans;
    }
}
