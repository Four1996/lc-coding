package leetcode.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 所有可能的路径
 * @author: panhao
 * @date: 2021-07-10 18:42
 **/
public class AllPathsSourceTarget_n793 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        ans=new ArrayList<>();
        path=new ArrayList<>();
        boolean[] vis=new boolean[n];
        path.add(0);
        dfs(graph,vis,0);
        return ans;
    }
    void dfs(int[][] graph,boolean[] vis,int k){
        if (k==graph.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[k]) {
            if (vis[next]) continue;
            path.add(next);
            vis[next]=true;
            dfs(graph,vis,next);
            vis[next]=false;
            path.remove(path.size()-1);
        }
    }

}
