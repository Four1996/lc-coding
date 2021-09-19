package leetcode;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-18 22:34
 **/
public class findOriginalArray_n5860 {
    public static int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len % 2 != 0) {
            return new int[0];
        }
        Arrays.sort(changed);
        HashMap<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(changed[i])){
                Deque<Integer> deque = map.get(changed[i]);
                deque.addFirst(i);
                map.put(changed[i],deque);
            }else{
                Deque<Integer> deque=new ArrayDeque<>();
                deque.addFirst(i);
                map.put(changed[i],deque);
            }
        }
        boolean[] vis = new boolean[len];
        int[] ans = new int[len / 2];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                int n = changed[i];
                if (n==0){
                    if (map.getOrDefault(n,new ArrayDeque<>()).size()<2){
                        return new int[0];
                    }else{
                        Deque<Integer> deque = map.get(n);
                        vis[deque.pollLast()]=true;
                        vis[deque.pollLast()]=true;
                        ans[idx++]=n;
                        if (deque.size()==0){
                            map.remove(n);
                        }else{
                            map.put(n,deque);
                        }
                    }
                }else if (n>0&&map.containsKey(n) && map.containsKey(n * 2)) {
                    ans[idx++] = n;
                    vis[i] = true;
                    Deque<Integer> deque1 = map.get(n);
                    Deque<Integer> deque2 = map.get(n * 2);
                    deque1.pollLast();
                    Integer k = deque2.pollLast();
                    vis[k]=true;
                    if (deque1.size()==0){
                        map.remove(n);
                    }else{
                        map.put(n,deque1);
                    }
                    if (deque2.size()==0){
                        map.remove(n*2);
                    }else{
                        map.put(n*2,deque2);
                    }

                } else {
                    return new int[0];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={0,0,0,0};
        for (int i : findOriginalArray(nums)) {
            System.out.println(i);
        }
    }
}
