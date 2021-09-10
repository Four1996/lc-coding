package leetcode.preTree;

import java.util.Arrays;

/**
 * @program: first
 * @description: 最短的单词编码
 * @author: panhao
 * @date: 2021-09-09 20:08
 **/
public class minimumLengthEncoding_n2179 {
    class TreeNode {
        boolean end;
        TreeNode[] child = new TreeNode[26];
    }

    TreeNode trie;

    public minimumLengthEncoding_n2179() {
        trie = new TreeNode();
    }

    public int insert(String word) {
        TreeNode cur = trie;
        char[] chars = word.toCharArray();
        boolean tag = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            int u = chars[i] - 'a';
            if (cur.child[u] == null) {
                tag = true;
                cur.child[u] = new TreeNode();
            }
            cur = cur.child[u];
        }
        cur.end = true;
        return tag ? word.length() + 1 : 0;
    }

    public int minimumLengthEncoding(String[] words) {
        int ans = 0;
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        for (String word : words) {
            ans += insert(word);
        }
        return ans;
    }
}
