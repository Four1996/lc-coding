package leetcode.preTree;

/**
 * @program: first
 * @description: 神奇的字典
 * @author: panhao
 * @date: 2021-09-08 14:04
 **/
public class MagicDictionary_n2178 {
    class TreeNode {
        boolean end;
        TreeNode[] node = new TreeNode[26];
    }

    TreeNode trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary_n2178() {
        trie = new TreeNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TreeNode root = trie;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (root.node[c - 'a'] == null) {
                    root.node[c - 'a'] = new TreeNode();
                }
                root = root.node[c - 'a'];
            }
            root.end = true;
        }
    }

    public boolean search(String searchWord) {
        char[] chars = searchWord.toCharArray();
        TreeNode p = trie;
        for (int i = 0; i < chars.length; i++) {
            int u = chars[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (p.node[j] != null && j != u) {
                    if (searchSub(searchWord.substring(i + 1), p.node[j])) {
                        return true;
                    }
                }
            }
            if (p.node[u] == null) {
                return false;
            }
            p = p.node[u];
        }
        return false;
    }

    private boolean searchSub(String subWord, TreeNode node) {
        char[] chars = subWord.toCharArray();
        for (char c : chars) {
            int u = c - 'a';
            if (node.node[u] == null) {
                return false;
            }
            node = node.node[u];
        }
        return node.end;
    }
}
