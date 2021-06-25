package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年05月20日 11:02 上午
 */
public class TopKFrequent_n347 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)-> {
                return map.get(o1)-map.get(o2);
        });
        for (int i:map.keySet()){
            queue.add(i);
            if (queue.size()>k) {
                queue.poll();
            }
        }
        int[] ans=new int[k];
        int i=ans.length-1;
        while (queue.size()>0){
            ans[i]=queue.poll();
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        for (int i:topKFrequent(nums,2)){
            System.out.println(i);
        }
    }
}
