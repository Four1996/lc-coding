package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 找到最终的安全状态（dfs+三色标记法）
 * @author: panhao
 * @date: 2021-08-05 14:33
 **/
public class EventualSafeNodes_n802_2 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] color=new int[n];
        for (int i = 0; i < n; i++) {
            if (safe(graph,color,i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static boolean safe(int[][] graph,int[] color,int x){
        if (color[x]>0) {
            return color[x] == 2;
        }
        color[x]=1;
        for (int y : graph[x]) {
            if (!safe(graph,color,y)){
                return false;
            }
        }
        color[x]=2;
        return true;
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
