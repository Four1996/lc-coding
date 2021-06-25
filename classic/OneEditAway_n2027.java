package leetcode.classic;

import java.util.HashMap;

/**
 * @program: first
 * @description: 一次编辑
 * @author: panhao
 * @date: 2021-06-21 09:35
 **/
public class OneEditAway_n2027 {
    public static boolean oneEditAway(String first, String second) {
        int l1=first.length(),l2=second.length();
        if (l1==0&&l2==0) return true;
        if (Math.abs(l1-l2)>1) return false;
        if (l1==l2){
            int diff=0;
            for (int i=0;i<l1;i++){
                if (first.charAt(i)!=second.charAt(i)) diff++;
            }
            return diff<2;
        }else{
            int diff=0;
            if (l1<l2){
                for (int i=0,j=0;i<l2&&j<l1;i++,j++){
                    if (second.charAt(i)!=first.charAt(j)){
                        while (i<l2&&second.charAt(i)!=first.charAt(j)){
                            diff++;
                            if (diff>1) return false;
                            i++;
                        }
                    }
                }
            }else{
                for (int i=0,j=0;i<l1&&j<l2;i++,j++){
                    if (first.charAt(i)!=second.charAt(j)) {
                        while (i<l1&&first.charAt(i)!=second.charAt(j)){
                            diff++;
                            if (diff>1) return false;
                            i++;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="teacher";
        String s2="taches";
        System.out.println(oneEditAway(s1,s2));
    }
}
