package leetcode.strings;

import java.util.HashSet;

/**
 * @program: first
 * @description: 单词长度的最大乘积
 * @author: panhao
 * @date: 2021-08-10 10:34
 **/
public class MaxProduct_n2086 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char[] chars = words[i].toCharArray();
            int c_len = chars.length;
            HashSet<Character> set = new HashSet<>();
            for (char ch : chars) {
                set.add(ch);
            }
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                char[] chars1 = words[j].toCharArray();
                boolean tag = false;
                for (char c : chars1) {
                    if (set.contains(c)) {
                        tag = true;
                        break;
                    }
                }
                if (tag) {
                    continue;
                } else {
                    ans = Math.max(ans, c_len * chars1.length);
                }

            }
        }
        return ans;
    }
}
