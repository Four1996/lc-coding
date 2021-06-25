package leetcode.classic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @program: first
 * @description: 节点间通路
 * @author: panhao
 * @date: 2021-06-25 10:46
 **/
public class FindWhetherExistsPath_n2048 {

    //朴素bfs，超时
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashSet<Integer> vis = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        int len = graph.length;
        if (len == 0) return false;
        if (start == target) return true;
        vis.add(start);
        for (int[] ints : graph) {
            if (ints[0] == start) {
                deque.addFirst(ints);
            }
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.pollLast();
                int next = poll[1];
                if (vis.contains(next)) continue;
                if (next == target) return true;
                vis.add(next);
                for (int[] ints : graph) {
                    if (ints[0] == next) deque.addFirst(ints);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1}, {0, 2}, {1, 2}, {1, 2}
        };
        System.out.println(findWhetherExistsPath(3, graph, 0, 2));
    }
}
