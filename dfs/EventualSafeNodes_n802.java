package leetcode.dfs;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 找到最终的安全状态（普通dfs超时了。。）
 * @author: panhao
 * @date: 2021-08-05 09:33
 **/
public class EventualSafeNodes_n802 {
    static boolean[] tag;
    static boolean[] vis;
    static List<Integer> ans;

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        tag = new boolean[n];
        vis = new boolean[n];
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!tag[i]) {
                vis[i]=true;
                for (int j=0;j<graph[i].length;j++){
                    if (tag[graph[i][j]]) {
                        tag[i]=true;
                        break;
                    }else{
                        dfs(graph,i,graph[i][j]);
                    }
                }
                if (!tag[i]) ans.add(i);
                vis[i]=false;
            }
        }
        return ans;
    }

    static void dfs(int[][] graph, int cur,int next) {
        if (vis[next] || tag[next]) {
            tag[cur] = true;
            return;
        }
        vis[next] = true;
        for (int i = 0; i < graph[next].length; i++) {
            if (!tag[cur] || !tag[graph[next][i]]) dfs(graph, cur, graph[next][i]);
            else break;
        }
        vis[next] = false;
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
