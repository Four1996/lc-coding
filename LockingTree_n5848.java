package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-04 23:08
 **/
public class LockingTree_n5848 {
    int n;
    boolean[] vis;
    int[] lockId;
    boolean tag = false;
    int[] parent;
    HashMap<Integer, List<Integer>> child;
    public LockingTree_n5848(int[] parent) {
        this.parent=parent;
        n = parent.length;
        vis = new boolean[n];
        lockId = new int[n];
        Arrays.fill(lockId, -1);
        child=new HashMap<>();
        for (int i = 0; i <n; i++) {
            child.put(i,new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (child.containsKey(parent[i])){
                child.get(parent[i]).add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (vis[num]) {
            return false;
        } else {
            vis[num] = true;
            lockId[num] = user;
            return true;
        }
    }

    public boolean unlock(int num, int user) {
        if (vis[num]) {
            if (lockId[num] == user) {
                vis[num] = false;
                lockId[num]=-1;
                return true;
            }
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (vis[num]) {
            return false;
        }
        int idx = parent[num];
        while (idx >-1) {
            if (vis[idx]){
                return false;
            }
            idx = parent[idx];
        }
        idx = num;
        List<Integer> list = child.get(idx);
        if (list.size()==0){
            return false;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for (Integer integer : list) {
            deque.addFirst(integer);
        }
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i = 0; i < size; i++) {
                int n = deque.pollLast();
                if (vis[n]){
                    tag=true;
                    vis[n]=false;
                    lockId[n]=-1;
                }
                if (child.get(n).size()>0){
                    for (Integer integer : child.get(n)) {
                        deque.addFirst(integer);
                    }
                }
            }
        }
        if (tag) {
            tag = false;
            vis[num] = true;
            lockId[num] = user;
            return true;
        }
        return false;
    }
}
