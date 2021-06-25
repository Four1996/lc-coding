package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月17日 9:43 下午
 */
public class IsHappy_n202 {
    public boolean isHappy(int n){
        if (n==1) return true;
        HashSet<Integer> hashset=new HashSet<>();
        hashset.add(n);
        n=getSquare(n);
        while(n!=1){
            if (hashset.contains(n)) return false;
            hashset.add(n);
            n=getSquare(n);
        }
        return true;
    }
    int getSquare(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            n=n/10;
            sum+=d*d;
        }
        return sum;
    }

    public static void main(String[] args) {
        IsHappy_n202 isHappy_n202=new IsHappy_n202();
        System.out.println(isHappy_n202.isHappy(19));
    }
}
