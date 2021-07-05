package leetcode.classic;

/**
 * @program: first
 * @description: 插入
 * @author: panhao
 * @date: 2021-07-05 15:00
 **/
public class InsertBits_n2077 {
    public static int insertBits(int N, int M, int _i, int _j) {

        String n = Integer.toBinaryString(N);
        String m = Integer.toBinaryString(M);
        StringBuilder nn = new StringBuilder(n);
        StringBuilder mm = new StringBuilder(m);
        nn = nn.reverse();
        mm = mm.reverse();
        char[] chars_n = nn.toString().toCharArray();
        char[] chars_m = mm.toString().toCharArray();
        int len_n = chars_n.length;
        int len_m = chars_m.length;
        if (len_n <= len_m) return M;
        int i = _i,j=0;

        for (; i < len_n && i <= _j && j < len_m; i++, j++) {
            chars_n[i] = chars_m[j];
        }
        while (i < len_n && i <= _j) {
            chars_n[i] = '0';
            i++;
        }
        StringBuilder ans = new StringBuilder();
        for (int k = chars_n.length - 1; k >= 0; k--) {
            ans.append(chars_n[k]);
        }
        while (j<len_m&&j<=_j){
            ans.insert(0,chars_m[j++]);
        }
        return Integer.parseInt(ans.toString(), 2);
    }

    public static void main(String[] args) {
        int N = 126194517;
        int M = 2982082;
        System.out.println(insertBits(N, M, 9, 30));
    }
}
