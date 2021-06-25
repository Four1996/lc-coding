package leetcode.classic;

/**
 * @program: first
 * @description: URL优化
 * @author: panhao
 * @date: 2021-06-21 09:12
 **/
public class ReplaceSpaces_n2025 {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();

        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
