package leetcode.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月05日 9:47 下午
 */
public class LastRemaining_n1990_2 {
    public int lastRemaining(int n, int m) {
        int ans=0;
        for (int i=2;i<=n;i++){
            ans=(ans+m)%i;
        }
        return ans;
    }
}
