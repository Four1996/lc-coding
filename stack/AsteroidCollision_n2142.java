package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 小行星碰撞
 * @author: panhao
 * @date: 2021-09-03 15:58
 **/
public class AsteroidCollision_n2142 {
    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        while (idx < len && asteroids[idx] < 0) {
            deque.addFirst(asteroids[idx]);
            idx++;
        }
        for (int i = idx; i < len; i++) {
            int left = asteroids[i];
            if (left > 0) {
                deque.addFirst(left);
            } else {
                if (!deque.isEmpty()) {
                    Integer right = deque.peekFirst();
                    if (-left != right) {
                        int cur = left + right;
                        if (cur>0){
                            continue;
                        }else{
                            while (!deque.isEmpty()&&deque.peekFirst()>0&&deque.peekFirst()<(-left)){
                                deque.pollFirst();
                            }
                            if (!deque.isEmpty()&&deque.peekFirst()>0&&deque.peekFirst()==(-left)){
                                deque.pollFirst();
                            }else if (deque.isEmpty()||deque.peekFirst()<0){
                                deque.addFirst(left);
                            }
                        }
                    }else{
                        deque.pollFirst();
                    }
                }else{
                    deque.addFirst(left);
                }
            }
        }
        int[] ans = new int[deque.size()];
        idx = 0;
        while (!deque.isEmpty()) {
            ans[idx++] = deque.pollLast();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,-1,-2,-2};
        System.out.println(asteroidCollision(nums));
    }
}
