package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 通过删除字母匹配到字典里最长单词
 * @author: panhao
 * @date: 2021-09-14 09:46
 **/
public class findLongestWord_n524 {
    class TreeNode {
        TreeNode[] child = new TreeNode[26];
        boolean end;
    }

    TreeNode root;

    public findLongestWord_n524() {
        root = new TreeNode();
    }

    public void insert(String s) {
        char[] chars = s.toCharArray();
        TreeNode p = root;
        for (char c : chars) {
            int u = c - 'a';
            if (p.child[u] == null) {
                p.child[u] = new TreeNode();
            }
            p = p.child[u];
        }
        p.end = true;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        char[] chars = s.toCharArray();
        String ans = "";
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        for (String s1 : dictionary) {
            insert(s1);
            set.add(s1);
        }
        TreeNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int u = chars[i] - 'a';
            if (p.child[u] != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(chars[i]);
                String temp = check(s, i + 1, p.child[u], new StringBuilder(sb));
                // System.out.println(temp);
                if (set.contains(temp) && temp.length() > maxLen) {
                    ans = temp;
                    maxLen = temp.length();
                } else if (set.contains(temp) && temp.length() == maxLen) {
                    int a = temp.compareTo(ans);
                    if (a < 0) {
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }

    public String check(String s, int idx, TreeNode p, StringBuilder sb) {
        char[] chars = s.toCharArray();
        for (int i = idx; i < s.length(); i++) {
            int u = chars[i] - 'a';
            if (p.child[u] == null) {
                return check(s, idx + 1, p, new StringBuilder(sb));
            } else {
                p = p.child[u];
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        findLongestWord_n524 f = new findLongestWord_n524();
        String[] strs = {"ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa"};
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strs));
        String s = "abpcplea";
        System.out.println(f.findLongestWord(s, list));
    }
}
