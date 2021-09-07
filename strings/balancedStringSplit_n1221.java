package leetcode.strings;

/**
 * @program: first
 * @description: 分割平衡字符串
 * @author: panhao
 * @date: 2021-09-07 10:02
 **/
public class balancedStringSplit_n1221 {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int balance = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (i > 0 && balance == 0) {
                ans++;
            }
        }
        return ans;
    }
}
