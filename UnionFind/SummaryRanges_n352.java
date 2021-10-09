package leetcode.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description: 将数据流变为多个不相交区间
 * @author: panhao
 * @date: 2021-10-09 21:40
 **/
public class SummaryRanges_n352 {
    private int[] father;

    public SummaryRanges_n352() {
        father = new int[10001];
        Arrays.fill(father, -1);
    }

    private int find(int x) {
        if (father[x] != x) {
            return father[x] = find(father[x]);
        }
        return father[x];
    }

    private void union(int x, int y) {
        if (x >= 0 && x <= 10000 && father[x] != -1 && father[y] != -1) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                father[fx] = fy;
            }
        }
    }

    public void addNum(int val) {
        if (father[val] == -1) {
            father[val] = val;
            union(val, val + 1);
            union(val - 1, val);
        }
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10001;) {
            if (father[i] != -1) {
                int start = i;
                int end = find(i);
                list.add(new int[]{start, end});
                i = end + 1;
            } else {
                i++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
