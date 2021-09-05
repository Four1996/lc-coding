package leetcode.strings;

/**
 * @program: first
 * @description: 移除无效的括号
 * @author: panhao
 * @date: 2021-09-04 18:47
 **/
public class MinRemoveToMakeValid_n1249_4 {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int balance = 0;
        int left = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                balance++;
                left++;
            }
            if (c == ')') {
                if (balance > 0) {
                    balance--;
                } else {
                    continue;
                }
            }
            temp.append(c);
        }
        int leftToSave = left - balance;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c == '(') {
                if (leftToSave > 0) {
                    leftToSave--;
                } else {
                    continue;
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}
