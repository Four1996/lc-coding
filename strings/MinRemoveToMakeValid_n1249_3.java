package leetcode.strings;

/**
 * @program: first
 * @description: 移除无效的括号
 * @author: panhao
 * @date: 2021-09-04 18:47
 **/
public class MinRemoveToMakeValid_n1249_3 {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                balance++;
                sb.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        s = sb.toString();
        StringBuilder res = new StringBuilder();
        balance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                balance++;
                res.append(c);
            } else if (c == '(') {
                if (balance > 0) {
                    balance--;
                    res.append(c);
                }
            } else {
                res.append(c);
            }
        }
        return res.reverse().toString();
    }
}
