package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 8:37 下午
 */
public class MissingNumber_n1976 {
    public int missingNumber(int[] nums) {
        int ans=0;
        for (int num : nums) {
            if (num==ans) ans++;
            else break;
        }
        return ans;
    }
}
