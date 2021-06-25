package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月30日 9:28 下午
 */
public class MedianFinder_n1962 {
     static boolean odd;
     static boolean even;
    PriorityQueue<Integer> minHeap,maxHeap;
    /** initialize your data structure here. */
    public MedianFinder_n1962() {
//        小顶堆
        minHeap=new PriorityQueue<>();
//        大顶堆
        maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        odd=false;
        even=true;
    }

    public void addNum(int num) {
        if (even){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            even=false;
            odd=true;
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            even=true;
            odd=false;
        }
    }

    public double findMedian() {
        if (odd){
            return minHeap.peek();
        }else{
            if (minHeap.size()==0&&maxHeap.size()==0) return 0;
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }
    }
}
