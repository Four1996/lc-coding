package leetcode;

/**
 * @author panhao
 * @date 2021年05月22日 9:45 上午
 */
public class XorGame_n810 {
    public boolean xorGame(int[] nums) {
        int n = nums.length, x = 0;
        if(n % 2 == 0) return true;
        for(int num : nums)
            x ^= num;
        return x == 0;
    }
}
