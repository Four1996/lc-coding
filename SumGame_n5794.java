package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-10 23:27
 **/
public class SumGame_n5794 {
    public boolean sumGame(String num) {
        char[] a = num.toCharArray();
        int nn = a.length;
        int x = 0, y = 0, m = 0, n = 0;
        for (int i = 0; i < nn / 2; i++) {
            if (a[i] == '?') m ++;
            else x += a[i] - '0';
        }
        for (int i = nn / 2; i < nn; i++) {
            if (a[i] == '?') n ++;
            else y += a[i] - '0';
        }
        if (x < y) {
            int t1 = y, t2 = n;
            y = x;
            x = t1;
            n = m;
            m = t2;
        }

        if (x == y && m == n) return false;
        if (m >= n) return true;
        if ((n - m) / 2 * 9 < x - y) return true;
        if ((n - m + 1) / 2 * 9 > x - y) return true;
        return false;
    }
}
