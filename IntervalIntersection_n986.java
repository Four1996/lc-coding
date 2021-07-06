package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description: 区间列表的交集
 * @author: panhao
 * @date: 2021-07-06 18:40
 **/
public class IntervalIntersection_n986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int l1 = firstList.length, l2 = secondList.length;
        if (l1 + l2 < 2) return new int[0][2];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < l1 && j < l2; ) {
            int s1 = firstList[i][0];
            int s2 = secondList[j][0];
            int e1 = firstList[i][1];
            int e2 = secondList[j][1];
            int start = Math.max(s1, s2);
            int end = Math.min(e1, e2);
            if (start <= end) {
                res.add(new ArrayList<>(Arrays.asList(start, end)));
            }
            if (end == e1) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[res.size()][2];
        int idx = 0;
        for (List<Integer> re : res) {
            ans[idx][0] = re.get(0);
            ans[idx][1] = re.get(1);
            idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] f={
                {3,5},{9,20}
        };
        int[][] s={
                {4,5},{7,10},{11,12},{14,15},{16,20}
        };
        System.out.println(intervalIntersection(f,s));
    }
}
