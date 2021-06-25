package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 8:45 上午
 */
public class MinimumTimeRequired_n1723 {
    int ans=Integer.MAX_VALUE;
    int[] jobs;
    int n,k;
    public int minimumTimeRequired(int[] _jobs, int _k) {
        jobs=_jobs;
        n=jobs.length;
        k=_k;
        int[] sum=new int[k];
        dfs(0,0,sum,0);
        return ans;
    }

    void dfs(int u, int used, int[] sum, int max) {
            if (max >= ans) return;
            if (u == n) {
                ans = max;
                return;
            }
            // 优先分配给「空闲工人」
            if (used < k) {
                sum[used] = jobs[u];
                dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
                sum[used] = 0;
            }
            for (int i = 0; i < used; i++) {
                sum[i] += jobs[u];
                dfs(u + 1, used, sum, Math.max(sum[i], max));
                sum[i] -= jobs[u];
            }
    }


}
