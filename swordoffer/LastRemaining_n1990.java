package leetcode.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月05日 9:47 下午
 */
public class LastRemaining_n1990 {
    public int lastRemaining(int n, int m) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int idx=0;
        while (n>1){
            idx=(idx+m-1)%n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
