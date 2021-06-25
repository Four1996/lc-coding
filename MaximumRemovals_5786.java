package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年06月13日 11:19 上午
 */
public class MaximumRemovals_5786 {
    public static int maximumRemovals(String s, String p, int[] removable) {
        int left=0,right=removable.length-1;
        while (left<right){
            int k=left+(right-left+1)/2;
            StringBuilder sb=new StringBuilder(s);
            for (int i=0;i<=k;i++){
                sb.setCharAt(removable[i],' ');
            }
            if (!judge(sb.toString(),p)){
                right=k-1;
            }else{
                left=k;
            }
        }
        StringBuilder sb=new StringBuilder(s);
        for (int i=0;i<=left;i++){
            sb.setCharAt(removable[i],' ');
        }
        if (judge(sb.toString(),p)) return left+1;
        return left;
    }

    static boolean judge(String s, String p) {
        int i = 0, j = 0;
        for (; i < s.length() && j < p.length(); ) {
            if (s.charAt(i)==p.charAt(j)){
                j++;
            }
            i++;
        }
        return j==p.length();
    }

    public static void main(String[] args) {
        String s = "abcab", p = "abc";
        int[] re = {0,1,2,3,4};
        System.out.println(maximumRemovals(s, p, re));
    }
}
