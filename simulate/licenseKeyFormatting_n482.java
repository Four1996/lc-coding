package leetcode.simulate;

/**
 * @program: first
 * @description: 密钥格式化
 * @author: panhao
 * @date: 2021-10-04 21:14
 **/
public class licenseKeyFormatting_n482 {
    public static String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        String[] split = s.split("-");
        StringBuilder sb = new StringBuilder();
        for (String ss : split) {
            sb.append(ss);
        }
        String temp = sb.toString();
        sb = new StringBuilder();
        int l = temp.length();
        int rest = l % k;
        int cur = 0;
        for (; cur < rest; cur++) {
            sb.append(temp.charAt(cur));
        }
        if (rest != 0) {
            sb.append("-");
        }
        for (int i = cur, j = 1; i < l; i++) {
            sb.append(temp.charAt(i));
            if (j % k == 0) {
                sb.append("-");
            }
            j++;
            j %= k;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="---";
        System.out.println(licenseKeyFormatting(s,2));
    }
}
