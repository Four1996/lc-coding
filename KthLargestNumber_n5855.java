package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-29 10:37
 **/
public class KthLargestNumber_n5855 {
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    if (o1.length()>o2.length()){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return o2.compareTo(o1);
            }
        });
        for (String num : nums) {
            queue.add(num);
        }
        int count=0;
        while (!queue.isEmpty()){
            String num = queue.poll();
            count++;
            if (count==k){
                return num;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] num={"3","6","7","10"};
        System.out.println(kthLargestNumber(num,4));
    }
}
