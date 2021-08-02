package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-01 10:30
 **/
public class isThree_n5830 {
    public boolean isThree(int n) {
        int k=1;
        if (n<1) return false;
        Set<Integer> set=new HashSet<>();
        while (k<n){
            int i;
            if (n%k==0){
                i=n/k;
                set.add(k);
                set.add(i);
            }
            k++;
        }
        return set.size()==3;
    }
}
