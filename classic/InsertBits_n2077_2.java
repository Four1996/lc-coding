package leetcode.classic;

/**
 * @program: first
 * @description: 插入
 * @author: panhao
 * @date: 2021-07-05 15:00
 **/
public class InsertBits_n2077_2 {
    public static int insertBits(int N, int M, int i, int j) {
        String s = Integer.toBinaryString(-1);
        String s1 = Integer.toBinaryString(-1 >>> (31 - j));
        String s2 = Integer.toBinaryString(~(-1 >>> (31 - j)));
        String s3 = Integer.toBinaryString(-1 << i);
        String s4 = Integer.toBinaryString(~(-1 >>> (31 - j) & (-1 << i)));
        int ll=-1>>>(31-j);
        int mm=-1<<i;

        int n=~((-1>>>(31-j))&(-1<<i));
        N=N&n;
        M=M<<i;
        N=M|N;
        return N;
    }

    public static void main(String[] args) {
        int N = 1024;
        int M = 19;
        System.out.println(insertBits(N, M, 2, 6));
    }
}
