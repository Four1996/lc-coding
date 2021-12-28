package leetcode.preTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: first
 * @description: 连接词
 * @author: panhao
 * @date: 2021-12-28 10:42
 **/
public class findAllConcatenatedWordsInADict_n472 {
    public class TreeNode {
        boolean end = false;
        TreeNode[] node = new TreeNode[26];
    }

    TreeNode trie = new TreeNode();

    public void insert(String word) {
        TreeNode p = trie;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.node[u] == null) {
                p.node[u] = new TreeNode();
            }
            p = p.node[u];
        }
        p.end = true;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<String>();
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (dfs(word, 0)) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public boolean dfs(String word, int s) {
        if (word.length() == s) {
            return true;
        }
        TreeNode p = trie;
        for (int i = s; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            p = p.node[u];
            if (p == null) {
                return false;
            }
            if (p.end) {
                if (dfs(word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
