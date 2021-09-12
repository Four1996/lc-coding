package leetcode.lcp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-11 15:11
 **/
public class maxmiumScore_n2 {
    public static int maxmiumScore(int[] cards, int cnt) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> even = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int card : cards) {
            if (card % 2 == 0) {
                even.add(card);
            } else {
                odd.add(card);
            }
        }
        int sum = 0;
        while (cnt > 0) {
            int sizeOdd = odd.size();
            int sizeEven = even.size();
            if (cnt<2){
                if (even.isEmpty()){
                    return 0;
                }else{
                    return sum+even.peek();
                }
            }else if (cnt==2&&sizeEven<2){
                if (sizeOdd>=2){
                    return sum+odd.poll()+odd.poll();
                }else {
                    return 0;
                }
            }else{
                List<Integer> list=new ArrayList<>();
                if (sizeOdd >= 2) {
                    list.add(odd.poll());
                    list.add(odd.poll());
                }
                int x=0;
                for (int num : list) {
                    x+=num;
                }
                int y = 0;
                if (sizeEven > 0) {
                    y = even.poll();
                }
                if (x > y) {
                    sum += x;
                    if (y!=0){
                        even.add(y);
                    }
                    cnt-=2;
                } else {
                    sum += y;
                    odd.addAll(list);
                    cnt--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={2,6,4};
        System.out.println(maxmiumScore(nums,3));
    }
}
