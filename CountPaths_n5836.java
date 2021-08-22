package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-21 22:52
 **/
public class CountPaths_n5836 {
    int mod= (int) (1e9+7);
    public int countPaths(int n, int[][] roads) {
        long[] step=new long[n];
        long[] pathNum=new long[n];
        int[][] graph=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                graph[i][j]=-1;
            }
        }
        pathNum[0]=1;
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(0);
        for (int[] road : roads) {
            int s=road[0];
            int e=road[1];
            int w=road[2];
            graph[s][e]=w;
            graph[e][s]=w;
        }
        long s;
        int from;
        while (!deque.isEmpty()){
            from=deque.pollLast();
            for (int i=1;i<n;i++){
                if (graph[from][i]!=-1){
                    s=step[from]+graph[from][i];
                    if (step[i]==0||step[i]>s){
                        step[i]=s;
                        pathNum[i]=pathNum[from]%mod;
                        deque.addFirst(i);
                    }else if (s==step[i]){
                        pathNum[i]=(pathNum[i]+pathNum[from])%mod;
                    }
                }
            }
        }
        return (int) (pathNum[n-1]%mod);
    }

    public static void main(String[] args) {

    }

}
