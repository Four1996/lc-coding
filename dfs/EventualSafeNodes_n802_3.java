package leetcode.dfs;

import java.util.*;

/**
 * @program:
 * @description: 找到最终的安全状态（反向拓扑排序）
 * @author: panhao
 * @date: 2021-08-05 14:33
 **/
public class EventualSafeNodes_n802_3 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> dumy_graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            dumy_graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                dumy_graph.get(graph[i][j]).add(i);

            }
            indegree[i] = graph[i].length;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                deque.addFirst(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.pollLast();
            ans.add(cur);
            for (int next : dumy_graph.get(cur)) {
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    deque.addFirst(next);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        // int[][] graph = {
        //         {1,2,3,4},{1,2},{3,4},{0,4},{}
        // };
        // int[][] graph = {
        //         {0},{2,3,4},{3,4},{0,4},{}
        // };
        System.out.println(eventualSafeNodes(graph));
    }
}
