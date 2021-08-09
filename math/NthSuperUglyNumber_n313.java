package leetcode.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @program: first
 * @description: 超级丑数
 * @author: panhao
 * @date: 2021-08-09 08:57
 **/
public class NthSuperUglyNumber_n313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        set.add(1L);
        int  count=0;
        while (count != n) {
            Long prime = queue.poll();
            count++;
            if (count==n) {
                return Math.toIntExact(prime);
            }
            for (int num : primes) {
                long temp = prime * num;
                if (!set.contains(temp)) {
                    queue.add(temp);
                    set.add(temp);
                }
            }
        }
        return Math.toIntExact(queue.poll());
    }

    public static void main(String[] args) {
        int[] primes={2,7,13,19};
        System.out.println(nthSuperUglyNumber(12,primes));
    }
}
