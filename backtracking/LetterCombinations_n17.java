package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 电话号码的字母组合
 * @author: panhao
 * @date: 2021-07-16 09:10
 **/
public class LetterCombinations_n17 {
    List<String> ans;
    HashMap<Integer, char[]> map;
    StringBuilder res;
    int len;

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        len = digits.length();
        if (len < 1) return new ArrayList<>();
        char[] nums = digits.toCharArray();
        res = new StringBuilder();
        map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        dfs(nums, 0);
        return ans;
    }

    public void dfs(char[] nums, int startIndex) {
        if (res.length() >= len) {
            ans.add(new String(res));
            return;
        }
        char[] chars = map.get(nums[startIndex] - '0');
        for (int i = 0; i < chars.length; i++) {
            res.append(chars[i]);
            dfs(nums, startIndex + 1);
            res.delete(res.length() - 1, res.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations_n17().letterCombinations("23"));
    }
}
