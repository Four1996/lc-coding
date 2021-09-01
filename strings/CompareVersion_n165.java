package leetcode.strings;

/**
 * @program: first
 * @description: 比较版本号
 * @author: panhao
 * @date: 2021-09-01 09:46
 **/
public class CompareVersion_n165 {
    public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int l1 = str1.length, l2 = str2.length;
        int l = Math.min(l1, l2);
        int i = 0;
        for (; i < l; i++) {
            int n1 = Integer.parseInt(str1[i]);
            int n2 = Integer.parseInt(str2[i]);
            if (n1 == n2) {
                continue;
            } else if (n1 > n2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (l == l1 && l == l2) {
            return 0;
        } else if (l == l1) {
            for (; i < l2; i++) {
                if (Integer.parseInt(str2[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            for (; i < l1; i++) {
                if (Integer.parseInt(str1[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String s1="1.0";
        String s2="1.0.0";
        System.out.println(compareVersion(s1,s2));
    }
}
