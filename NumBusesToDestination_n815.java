package leetcode;

import java.util.*;

/**
 * @program: first
 * @description: 公交路线
 * @author: panhao
 * @date: 2021-06-28 09:37
 **/
public class NumBusesToDestination_n815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target) return 0;
        int ans=0;
        int len=routes.length;
        boolean[][] edge=new boolean[len][len];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<len;i++){
            for (int site : routes[i]) {
                List<Integer> list=map.getOrDefault(site,new ArrayList<Integer>());
                for (int j:list){
                    edge[i][j]=edge[j][i]=true;
                }
                list.add(i);
                map.put(site,list);
            }
        }

        int[] dis=new int[len];
        Arrays.fill(dis,-1);
        Deque<Integer> deque=new ArrayDeque<>();
        for (Integer integer : map.getOrDefault(source, new ArrayList<>())) {
            dis[integer]=1;
            deque.addFirst(integer);
        }
        while (!deque.isEmpty()){
            int x=deque.pollLast();
            for (int y=0;y<len;y++){
                if (edge[x][y]&&dis[y]==-1){
                    dis[y]=dis[x]+1;
                    deque.addFirst(y);
                }
            }
        }
        int ret=Integer.MAX_VALUE;
        for (Integer integer : map.getOrDefault(target, new ArrayList<>())) {
            if (dis[integer]!=-1){
                ret=Math.min(ret,dis[integer]);
            }
        }

        return ret==Integer.MAX_VALUE?-1:ret;
    }
}
