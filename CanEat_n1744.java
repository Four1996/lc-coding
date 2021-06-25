package leetcode;

/**
 * @author panhao
 * @date 2021年06月01日 8:48 上午
 */
public class CanEat_n1744 {
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length, m = candiesCount.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; i++) sum[i] = sum[i - 1] + candiesCount[i - 1];
        for (int i = 0; i < n; i++) {
            int t = queries[i][0], d = queries[i][1] + 1, c = queries[i][2];
            long a = sum[t] / c + 1, b = sum[t + 1];
            ans[i] = a <= d && d <= b;
        }
        return ans;

    }

    public static void main(String[] args) {
        String s="true,true,true,true,true,true,true,true,false,false,true,true,false,false,false,true,true,false,false,false,false,false,false,false,false,true,false,false,false,false,true";
        int[] candies={16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8};
        int sum=0;
        for (int candy : candies) {
            sum+=candy;
        }
        int[][] nums={{43,1054,49}};
        int pre=sum-5;
        System.out.println(sum);
        System.out.println(pre);
        String[] split = s.split(",");
        System.out.println(split.length);
        System.out.println(candies.length);
        canEat(candies,nums);

    }
}
