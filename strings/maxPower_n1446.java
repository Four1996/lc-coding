package leetcode.strings;

/**
 * @program: first
 * @description: 连续字符
 * @author: panhao
 * @date: 2021-12-01 14:51
 **/
public class maxPower_n1446 {
    public int maxPower(String s) {
        int len = s.length();
        int ans = 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count > 1) {
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
