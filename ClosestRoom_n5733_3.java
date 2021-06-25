package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年05月01日 11:31 下午
 */
public class ClosestRoom_n5733_3 {
    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        int idx = 0;
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int[][] q=new int[queries.length][3];
        for (int i=0;i< queries.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (int i = 0; i < queries.length; i++) {
            while (idx < rooms.length&&rooms[idx][1] >= q[i][1]) {
                set.add(rooms[idx][0]);
                idx++;
            }
            Integer a = set.floor(q[i][0]);//返回小于等于房间id的最大值
            Integer b = set.ceiling(q[i][0]);//返回大于等于房间id的最小值
            if (a == null && b == null) {
                ans[q[i][2]] = -1;
            } else if (a == null || b == null) {
                if (a == null) ans[q[i][2]] = b;
                else ans[q[i][2]] = a;
            } else {
                int u = Math.abs(a - q[i][0]);
                int k = Math.abs(b - q[i][0]);
                if (u == k) ans[q[i][2]] = a;
                else ans[q[i][2]] = u > k ? b : a;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] rooms = {{1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}};
        int[][] q = {{2, 3}, {2, 4}, {2, 5}};
        for (int i : closestRoom(rooms, q)) {
            System.out.println(i);
        }
//        TreeSet<Integer> treeSet=new TreeSet();
//        treeSet.add(5);
//        treeSet.add(10);
//        treeSet.add(2);
//        treeSet.add(11);
//        Integer ceiling = treeSet.ceiling(6);
//        System.out.println(ceiling);
//        System.out.println(treeSet);

    }
}
