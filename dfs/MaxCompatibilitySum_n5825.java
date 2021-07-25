package leetcode.dfs;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-25 10:56
 **/
public class MaxCompatibilitySum_n5825 {

    boolean[] men_vis;
    int ans = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int len = students.length;

        men_vis = new boolean[len];
        dfs(students, 0, mentors, 0, 0);
        return ans;
    }

    void dfs(int[][] students, int stu_idx, int[][] mentors, int count, int sum) {
        if (count >= students.length) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int j = 0; j < mentors.length; j++) {
            if (men_vis[j]) continue;
            men_vis[j] = true;
            int cc = 0;
            for (int k = 0; k < mentors[j].length; k++) {
                if (students[stu_idx][k] == mentors[j][k]) cc++;
            }
            dfs(students, stu_idx + 1, mentors, count + 1, sum + cc);
            men_vis[j] = false;
        }
    }

    public static void main(String[] args) {
        int[][] s = {
                {0, 0, 1, 1, 1, 0, 1}, {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1}
                // {1, 1, 0}, {1, 0, 1}, {0, 0, 1}
                // {0,0},{0,0},{0,0}
        };
        int[][] m = {
                // {1, 0, 0}, {0, 0, 1}, {1, 1, 0}
                // {1,1},{1,1},{1,1}
                {0, 1, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(new MaxCompatibilitySum_n5825().maxCompatibilitySum(s, m));
    }
}
