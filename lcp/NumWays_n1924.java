package leetcode.lcp;

import java.util.*;

/**
 * @program: first
 * @description: 传递消息
 * @author: panhao
 * @date: 2021-07-01 08:53
 **/
public class NumWays_n1924 {
    public static int numWays(int n, int[][] relation, int k) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int len = relation.length;
        for (int i = 0; i < len; i++) {
            int key = relation[i][0];
            int value = relation[i][1];
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(value);
            map.put(key, list);
        }
        List<Integer> start = map.getOrDefault(0, new ArrayList<>());
        for (Integer integer : start) {
            if (integer == n - 1 && k == 0) ans++;
            deque.addFirst(integer);
        }
        if (k == 0) return ans;
        int step = 0;
        // 步数>=k就退出搜索。
        while (!deque.isEmpty() && step < k) {
            int size = deque.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer key = deque.pollLast();
                // 步数等于k，并且当前搜索结点==目标节点，ans+1。
                if (key == n - 1 && k == step) ans++;
                List<Integer> nextList = map.getOrDefault(key, new ArrayList<>());
                for (Integer next : nextList) {
                    deque.addFirst(next);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[][] rel={
        //         {0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
        // };
        int[][] rel = {
                {0, 2}, {2, 1}
        };
        System.out.println(numWays(3, rel, 2));
    }

}
