package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年05月20日 2:17 下午
 */
public class FrequencySort_n451 {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (map.containsKey(c)) map.put(c,map.get(c)+1);
            else map.put(c,1);
        }
        PriorityQueue<Character> queue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1)==map.get(o2)) return o1.compareTo(o2);
                else return map.get(o2)-map.get(o1);
            }
        });
        StringBuilder ans=new StringBuilder();
        for (char c:map.keySet()){
            queue.add(c);
        }
        while (queue.size()>0){
            char c=queue.poll();
            int i=map.get(c);
            while (i>0) {
                ans.append(c);
                i--;
            }
        }
        return ans.toString();
    }
}
