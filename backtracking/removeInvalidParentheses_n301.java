package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: first
 * @description: 删除无效的括号
 * @author: panhao
 * @date: 2021-10-27 19:43
 **/
public class removeInvalidParentheses_n301 {
    Set<String> ans;
    int max;
    int tempMaxLen;

    public List<String> removeInvalidParentheses(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        ans = new HashSet<>();
        max = 0;
        for (char c : chars) {
            if (c == '(') {
                max++;
            }
        }
        max = Math.min(len - max, max);
        tempMaxLen = 0;

        dfs(0, chars, 0, "");
        return new ArrayList<>(ans);
    }

    public void dfs(int score, char[] chars, int idx, String temp) {
        if (score < 0 || score > max) {
            return;
        }
        if (idx == chars.length) {
            if (score == 0 && temp.length() >= tempMaxLen) {
                if (temp.length() > tempMaxLen) {
                    ans.clear();
                }
                tempMaxLen = temp.length();
                ans.add(temp.toString());
            }
            return;
        }
        char c = chars[idx];
        if (c == '(') {
            dfs(score + 1, chars, idx + 1, temp + c);
            dfs(score, chars, idx + 1, temp);
        } else if (c == ')') {
            dfs(score - 1, chars, idx + 1, temp + c);
            dfs(score, chars, idx + 1, temp);
        } else {
            dfs(score, chars, idx + 1, temp + c);
        }
    }
}
