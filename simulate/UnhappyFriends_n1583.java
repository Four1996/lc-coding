package leetcode.simulate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: first
 * @description: 统计不开心的朋友
 * @author: panhao
 * @date: 2021-08-14 19:41
 **/
public class UnhappyFriends_n1583 {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // 期望
        HashMap<Integer, int[]> expect = new HashMap<>();
        for (int i = 0; i < n; i++) {
            expect.put(i, preferences[i]);
        }
        // 现实
        HashMap<Integer, Integer> reality = new HashMap<>();
        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            reality.put(x, y);
            reality.put(y, x);
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = reality.get(x);
            int[] x_expects = expect.get(x);
            for (int u = 0; u < n; u++) {
                if (u == x || u == y) {
                    continue;
                } else {
                    // 先针对x的关系数组对比u和y的下标
                    int xfirst_meet = -1;
                    for (int x_expect : x_expects) {
                        if (x_expect == y) {
                            xfirst_meet = y;
                            break;
                        } else if (x_expect == u) {
                            xfirst_meet = u;
                            break;
                        }
                    }
                    int v = reality.get(u);
                    int[] u_expects = expect.get(u);
                    // 针对u的关系数组对比x和v的下标
                    int ufirst_met = -1;
                    for (int u_expect : u_expects) {
                        if (u_expect == x) {
                            ufirst_met = x;
                            break;
                        } else if (u_expect == v) {
                            ufirst_met = v;
                            break;
                        }
                    }
                    if (xfirst_meet == u && ufirst_met == x) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] preferences={
                {1,2,3},{3,2,0},{3,1,0},{1,2,0}
        };
        int[][] pairs={
                {0,1},{2,3}
        };
        System.out.println(unhappyFriends(4,preferences,pairs));
    }
}
