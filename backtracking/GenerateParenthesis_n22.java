package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 括号生成
 * @author: panhao
 * @date: 2021-07-16 10:25
 **/
public class GenerateParenthesis_n22 {
    List<String> ans;
    HashMap<Character, Integer> map;
    StringBuilder res;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        map.put('(', n);
        map.put(')', n);
        res = new StringBuilder();
        dfs(n);
        return ans;
    }

    public void dfs(int n) {
        if (res.length() == n * 2) {
            ans.add(new String(res));
            return;
        }
        int n1 = map.get('(');
        int n2 = map.get(')');
        if (n1 == n2) {
            res.append("(");
            map.put('(', n1 - 1);
            dfs(n);
            res.delete(res.length() - 1, res.length());
            map.put('(', n1);
        } else {
            if (n1 > 0) {
                res.append("(");
                map.put('(', n1 - 1);
                dfs(n);
                map.put('(', n1);
                res.delete(res.length() - 1, res.length());
                res.append(")");
                map.put(')', n2 - 1);
                dfs(n);
                map.put(')', n2);
                res.delete(res.length() - 1, res.length());
            } else {
                res.append(")");
                map.put(')', n2 - 1);
                dfs(n);
                map.put(')', n2);
                res.delete(res.length() - 1, res.length());
            }
        }
    }
}

