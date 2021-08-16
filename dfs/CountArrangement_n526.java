package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 优美的排列
 * @author: panhao
 * @date: 2021-08-16 09:00
 **/
public class CountArrangement_n526 {
    int N;
    int ans;
    int mask=0;
    public int countArrangement(int n) {
        ans=0;
        N =n;
        dfs(1);
        return ans;
    }
    void dfs(int cur) {
        if (cur == N + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!(((mask >> (i - 1)) & 1) == 1) && (cur % i == 0 || i % cur == 0)) {
                mask = mask ^ (1 << (i - 1));
                dfs( cur + 1);
                mask = mask ^ (1 << (i - 1));
            }
        }
    }
}
