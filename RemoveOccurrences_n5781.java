package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-26 22:46
 **/
public class RemoveOccurrences_n5781 {
    public static String removeOccurrences(String s, String part) {
        int m = s.length(), n = part.length();
        if (m < n) return s;
        for (int i = 0; i < m - n + 1; i++) {
            if (s.substring(i, i + n).equals(part)) {
                s = s.substring(0, i) + s.substring(i + n);
                return removeOccurrences(s, part);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "aabababa";
        String part = "aba";
        System.out.println(removeOccurrences(s, part));
    }
}
