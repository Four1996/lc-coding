package leetcode.dp;

import java.util.*;

/**
 * @program: first
 * @description: K站中转内最便宜的航班
 * @author: panhao
 * @date: 2021-08-24 09:18
 **/
public class FindCheapestPrice_n787_2 {
    public static class Node{
        int idx;
        int w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //steps-1步到达i结点所花费的最少步数。
        int[] preCost=new int[n];
        Arrays.fill(preCost,Integer.MAX_VALUE);
        // steps步到达i阶段所发费的最少步数。
        int[] costs=new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);

        List<List<Node>> arc=new ArrayList<>();
        for (int i=0;i<n;i++){
            arc.add(new ArrayList<>());
        }
        // 邻接表初始化
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            arc.get(from).add(new Node(to,cost));
        }

        int steps = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(src);
        while (!deque.isEmpty()) {
            if (steps > k) {
                break;
            }
            // 第step所能到达的结点。
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int cur = deque.pollLast();
                List<Node> nodes = arc.get(cur);
                for (Node node : nodes) {
                    deque.addFirst(node.idx);
                    if (steps > 0 && preCost[cur] != Integer.MAX_VALUE) {
                        costs[node.idx] = Math.min(preCost[cur] + node.w, costs[node.idx]);
                    } else if (steps == 0) {
                        preCost[node.idx] = node.w;
                    }
                }

            }
            if (steps>0){
                preCost = Arrays.copyOfRange(costs, 0, n);
            }
            steps++;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
        };
        System.out.println(findCheapestPrice(4, nums, 0, 3, 1));
    }
}
