package leetcode.graph;

import java.util.*;

/**
 * @program: graph
 * @description: 访问所有节点的最短路径
 * @author: panhao
 * @date: 2021-08-06 09:54
 **/
public class ShortestPathLength_n847 {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        Deque<int[]> deque=new ArrayDeque<>();
        boolean[][] vis=new boolean[n][1<<n];
        for (int i=0;i<n;i++){
            deque.addFirst(new int[]{i,1<<i,0});
            vis[i][1<<i]=true;
        }
        int ans=0;
        while (!deque.isEmpty()){
            int[] tuple=deque.pollLast();
            int u=tuple[0],mask=tuple[1],dist=tuple[2];
            if (mask==(1<<n)-1){
                ans=dist;
                break;
            }
            // 搜索相邻的结点
            for (int v : graph[u]) {
                // 将mask的第v位置为1
                int maskv=mask|(1<<v);
                if (!vis[v][maskv]){
                    deque.addFirst(new int[]{v,maskv,dist+1});
                    vis[v][maskv]=true;
                }
            }
        }
        return ans;
    }
}
