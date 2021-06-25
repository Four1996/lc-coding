package leetcode;

import java.util.*;

/**
 * @program: first
 * @description: 打开转盘锁
 * @author: panhao
 * @date: 2021-06-25 09:30
 **/
public class OpenLock_n752 {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) return 0;
        HashSet<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) return -1;
        int step = 0;
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("0000");
        HashSet<String> vis = new HashSet<>();
        vis.add("0000");

        while (!deque.isEmpty()) {
            step++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String poll = deque.pollLast();
                for (String s : get(poll)) {
                    if (dead.contains(s) || vis.contains(s)) continue;
                    if (s.equals(target)) return step;
                    deque.addFirst(s);
                    vis.add(s);
                }
            }
        }
        return -1;
    }

    public List<String> get(String str) {
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int n = chars[i] - '0';
            int pre = n == 0 ? 9 : n - 1;
            int next = (n + 1) % 10;
            String pre_str = str.substring(0, i) + pre + str.substring(i + 1);
            String next_str = str.substring(0, i) + next + str.substring(i + 1);
            list.add(pre_str);
            list.add(next_str);
        }
        return list;
    }
}
