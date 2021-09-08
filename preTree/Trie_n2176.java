package leetcode.preTree;

/**
 * @program: first
 * @description: 前缀树
 * @author: panhao
 * @date: 2021-09-07 18:53
 **/
public class Trie_n2176 {
    class TreeNode{
        boolean end;
        TreeNode[] chars=new TreeNode[26];
    }
    TreeNode trie;
    /** Initialize your data structure here. */
    public Trie_n2176() {
        trie=new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode p=trie;
        for (int i = 0; i < word.length(); i++) {
            int u=word.charAt(i)-'a';
            if (p.chars[u]==null){
                p.chars[u]=new TreeNode();
            }
            p=p.chars[u];
        }
        p.end=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode p=trie;
        for (int i = 0; i < word.length(); i++) {
            int u=word.charAt(i)-'a';
            if (p.chars[u]==null){
                return false;
            }
            p=p.chars[u];
        }
        return p.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode p=trie;
        for (int i = 0; i < prefix.length(); i++) {
            int u=prefix.charAt(i)-'a';
            if (p.chars[u]==null){
                return false;
            }
            p=p.chars[u];
        }
        return true;
    }
}
