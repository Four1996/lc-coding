package leetcode.preTree;

import java.util.HashMap;

/**
 * @program: first
 * @description: 单词之和
 * @author: panhao
 * @date: 2021-09-10 10:28
 **/
public class MapSum_n2180 {
    class TreeNode {
        boolean end;
        int val;
        TreeNode[] child = new TreeNode[26];
    }

    TreeNode trie;
    HashMap<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MapSum_n2180() {
        trie = new TreeNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {

        TreeNode cur = trie;
        char[] chars = key.toCharArray();
        boolean tag = false;
        int diff = 0;
        if (map.containsKey(key)) {
            int pre = map.get(key);
            diff = val - pre;
            tag = true;
        }
        map.put(key, val);
        for (char c : chars) {
            int u = c - 'a';
            if (cur.child[u] == null) {
                cur.child[u] = new TreeNode();
            }
            if (tag) {
                cur.child[u].val += diff;
            } else {
                cur.child[u].val += val;
            }
            cur = cur.child[u];
        }
        cur.end = true;
    }

    public int sum(String prefix) {
        TreeNode cur = trie;
        char[] chars = prefix.toCharArray();
        int sum = 0;
        for (char c : chars) {
            int u = c - 'a';
            if (cur.child[u] == null) {
                sum=0;
                break;
            } else {
                sum = cur.child[u].val;
                cur = cur.child[u];
            }
        }
        return sum;
    }
}
