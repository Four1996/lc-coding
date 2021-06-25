package leetcode.swordoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月03日 4:09 下午
 */
public class MinNumber_n1967 {
    public String minNumber(int[] nums) {

        PriorityQueue<String> queue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x=o1+o2;
                String y=o2+o1;
                if (x.compareTo(y)>0) return 1;
                return -1;
            }
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1="3"+"30";
        String s2="30"+"3";

        System.out.println(s1.compareTo(s2));
        int[] nums={3,30,34,5,9};
        System.out.println(new MinNumber_n1967().minNumber(nums));
    }
}
