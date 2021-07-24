package leetcode;

/**
 * @program: first
 * @description: 替换隐藏数字得到的最晚时间
 * @author: panhao
 * @date: 2021-07-24 12:38
 **/
public class MaximumTime_n1736 {
    public String maximumTime(String time) {
        int len = time.length();
        char[] chars = time.toCharArray();
        char pre = ' ';
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (chars[i] == '?' && ((chars[i + 1] < '4' && chars[i + 1] >= '0') || chars[i + 1] == '?')) {
                    chars[i] = '2';
                }
                if (chars[i] == '?') {
                    chars[i] = '1';
                }
                pre = chars[i];
            } else if (i == 1) {
                if (chars[i] == '?') {
                    if (pre == '2') chars[i] = '3';
                    else {
                        chars[i] = '9';
                    }
                }
                pre = chars[i];
            } else if (i == 3) {
                if (chars[i] == '?') {
                    chars[i] = '5';
                }
            } else if (i == 4) {
                if (chars[i] == '?') {
                    chars[i] = '9';
                }
            }
        }
        return new String(chars);
    }
}
