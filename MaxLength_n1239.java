package leetcode;

import java.util.*;

/**
 * @program: first
 * @description: 串联字符串的最大长度
 * @author: panhao
 * @date: 2021-06-19 09:22
 **/
public class MaxLength_n1239 {

    int max = 0;
    StringBuilder sb;

    public int maxLength(List<String> arr) {
        sb = new StringBuilder();
        dfs(arr, 0);
        return max;
    }

    public void dfs(List<String> arr, int idx) {
        char[] ch = sb.toString().toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : ch) {
            if (set.contains(c)) {
                return;
            }
            set.add(c);
        }
        max = Math.max(max, sb.length());
        for (int i = idx; i < arr.size(); i++) {
            sb.append(arr.get(i));
            dfs(arr, i + 1);
            sb.delete(sb.length() - arr.get(i).length(), sb.length());
        }
        return;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        Collections.addAll(arr, "a", "abc", "d", "de", "def");
        System.out.println(new MaxLength_n1239().maxLength(arr));

    }
}
