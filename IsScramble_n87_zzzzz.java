package leetcode;

/**
 * @author panhao
 * @date 2021年04月16日 6:34 下午
 */
public class IsScramble_n87_zzzzz {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (!check(s1, s2)) return false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // s1 的 [0,i) 和 [i,n)
            String a = s1.substring(0, i), b = s1.substring(i);
            // s2 的 [0,i) 和 [i,n)
            String c = s2.substring(0, i), d = s2.substring(i);
            if (isScramble(a, c) && isScramble(b, d)) return true;
            // s2 的 [0,n-i) 和 [n-i,n)
            String e = s2.substring(0, n - i), f = s2.substring(n - i);
            if (isScramble(a, f) && isScramble(b, e)) return true;
        }
        return false;
    }
    // 检查 s1 和 s2 词频是否相同
    boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt1[cs1[i] - 'a']++;
            cnt2[cs2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="abcde",s2="caebd";
        IsScramble_n87_zzzzz isScramble_n87Zzzzz =new IsScramble_n87_zzzzz();
        System.out.println(isScramble_n87Zzzzz.isScramble(s1,s2));
    }
}
