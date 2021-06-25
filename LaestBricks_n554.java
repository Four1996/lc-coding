package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月02日 6:28 下午
 */
public class LaestBricks_n554 {
    public int leastBricks(List<List<Integer>> wall){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (List<Integer> list:wall){
            int n=list.size();
            int sum=0;
            for (int i=0;i<n-1;i++){
                sum+=list.get(i);
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        int max=0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            max=Math.max(max,entry.getValue());
        }
        return wall.size()-max;
    }
}
