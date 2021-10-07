package leetcode.strings;

/**
 * @program: first
 * @description: 字符串的单词数
 * @author: panhao
 * @date: 2021-10-07 14:18
 **/
public class countSegments_n434 {
    public static int countSegments(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            if (c == ' ') {
                ans++;
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            } else {
                i++;
            }
        }
        return chars.length == 0 ? 0 : ++ans;
    }

    public static void main(String[] args) {
        String s="";
        System.out.println(countSegments(s));
    }
}
