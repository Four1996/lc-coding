package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-24 22:34
 **/
public class SmallestChair_n5805 {
    public static int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int start=times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> desk=new PriorityQueue<>();
        for (int i=0;i<n;i++){
            desk.add(i);
        }
        PriorityQueue<int[]> people=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        Deque<Integer> wait =new ArrayDeque<>();
        for (int i=0,time=0;i<n;){
            if (people.isEmpty()){
                int desk_poll = desk.poll();
                people.add(new int[]{desk_poll,times[i][1]});
                time=times[i][0];
                i++;

            }else {
                while (i<n&&time>=times[i][0]) {
                    wait.addFirst(i);
                    i++;
                }
                // 删除到时的凳子。
                while (!people.isEmpty()&&time>=people.peek()[1]){
                    int[] poll = people.poll();
                    int d=poll[0];
                    desk.add(d);
                }
                if (!desk.isEmpty()){
                    while (!wait.isEmpty()&&!desk.isEmpty()){
                        int cur = wait.pollLast();
                        int ss=times[cur][0];
                        int ee=times[cur][1];
                        if (ss==start) return desk.peek();
                        Integer desk_poll = desk.poll();
                        people.add(new int[]{desk_poll,ee});
                    }
                }
                time++;
            }
            if (i>0&&wait.isEmpty()){
                i++;
                if (i<n&&time<=times[i][0]){
                    wait.addFirst(i);
                    time=times[i][0];
                }else if (i<n&&time>times[i][0]){
                    wait.addFirst(i);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // int[][] nums={
        //         {33889,98676},{80071,89737},{44118,52565},{52992,84310},
        //         {78492,88209},{21695,67063},{84622,95452},{98048,98856},
        //         {98411,99433},{55333,56548},{65375,88566},{55011,62821},
        //         {48548,48656},{87396,94825},{55273,81868},{75629,91467}
        // };
        int[][] nums={
                {1,4},{2,3},{4,6}
        };
        System.out.println(smallestChair(nums,1));
    }
}
