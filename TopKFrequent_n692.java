package leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月20日 9:23 上午
 */
public class TopKFrequent_n692 {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> list=new LinkedList<>();

        HashMap<String,Integer> map=new HashMap<>();
        for (String str:words){
            if (map.containsKey(str)) {
                int u=map.get(str);
                map.put(str,u+1);
            }else{
                map.put(str,1);
            }
        }
        PriorityQueue<String> minHeap=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) return o2.compareTo(o1);
                else return map.get(o1)-map.get(o2);
            }
        });
//        PriorityQueue<String> minHeap=new PriorityQueue<>((o1,o2)-> {
//            if (map.get(o1).equals(map.get(o2))) return o2.compareTo(o1);
//            else return map.get(o1)-map.get(o2);
//        });
        for (String s:map.keySet()){
            minHeap.add(s);
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }
        while (minHeap.size()>0){
            list.addFirst(minHeap.poll());
        }
        return list;
    }

}
