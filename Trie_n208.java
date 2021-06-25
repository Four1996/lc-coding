package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月14日 9:17 下午
 */
public class Trie_n208 {
    class TreeNode{
        boolean end;
        TreeNode[] word=new TreeNode[26];
    }
    TreeNode trie;
    public Trie_n208() {
        trie=new TreeNode();
    }
    public void insert(String a){
        TreeNode p=trie;
        for (int i=0;i<a.length();i++){
            int u=a.charAt(i)-'a';
            if (p.word[u]==null) p.word[u]=new TreeNode();
            p=p.word[u];
        }
       p.end=true;
    }
    public boolean search(String s){
        TreeNode p=trie;
        for (int i=0;i<s.length();i++){
            int u=s.charAt(i)-'a';
            if (p.word[u]==null) return false;
            p=p.word[u];
        }
        return p.end;
    }
    public boolean startsWith(String prefix){
        TreeNode p=trie;
        for (int i=0;i<prefix.length();i++){
            int u=prefix.charAt(i)-'a';
            if (p.word[u]==null) return false;
            p=p.word[u];
        }
        return true;
    }
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("apple");
        list.add("apple");
        System.out.println(list);
    }
}
