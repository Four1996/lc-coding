package leetcode.classic;

import java.util.*;

/**
 * @program: first
 * @description: 节点间通路
 * @author: panhao
 * @date: 2021-06-25 10:46
 **/
public class FindWhetherExistsPath_n2048_2 {

    //优化bfs
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //访问标记
        boolean[] vis = new boolean[n];

        //创建邻接表
        ArrayList[] lists = new ArrayList[n];
        for (int i=0;i<n;i++){
            lists[i]=new ArrayList<Integer>();
        }
        for (int[] ints : graph) {
            lists[ints[0]].add(ints[1]);
        }

        //bfs
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(start);
        vis[start]=true;
        while (!deque.isEmpty()){
            Integer integer = deque.pollLast();
            for (int i=0;i<lists[integer].size();i++){
                int nb = (int) lists[integer].get(i);
                if (vis[nb]) continue;
                if (nb==target) return true;
                vis[nb]=true;
                deque.addFirst(nb);
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
