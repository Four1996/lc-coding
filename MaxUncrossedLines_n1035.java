package leetcode;

/**
 * @author panhao
 * @date 2021年05月21日 9:02 上午
 */
public class MaxUncrossedLines_n1035 {
    public static int[][] maxUncrossedLines(int[] s1, int[] s2) {
        int n = s1.length, m = s2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (s1[i - 1] == s2[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f;

    }

    public static void main(String[] args) {
        int[] nums1={3,1,4,1,1,3,5,1,2,2};
        int[] nums2={4,1,5,2,1,1,1,5,3,1,1,1,2,3,1,4,3,5,5,3,1,2,3,2,4,1,1,1,5,3};
        for (int[] i:maxUncrossedLines(nums1,nums2)){
            for (int j:i){
                System.out.print(j+",");
            }
            System.out.println();
        }

    }
}
