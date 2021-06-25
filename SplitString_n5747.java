package leetcode;

import test.demo03_sleep.Sleep;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月02日 10:48 上午
 */
public class SplitString_n5747 {
    public static boolean splitString(String s) {
        int idx=0;
        while (s.charAt(idx)=='0')s=s.substring(1);
        int len=s.length();
        for (int i=0;i<=(len/2)+1;++i){
            long pre=Long.valueOf(s.substring(0,i+1));
            if (i==s.length()){
                return true;
            }
            if (find(s.substring(i),pre)){
                return true;
            }
        }

        return false;
    }
    static boolean find(String s,Long pre){
        if (s.length()==1){
            if (Long.valueOf(s)==pre-1) return true;
            else return false;
        }
        int idx=0;
        while (s.charAt(idx)=='0') s=s.substring(1);//消除前导0
        long cur;
        for (int i=0;i<=s.length();++i){
            cur=Long.valueOf(s.substring(0,i+1));
            if (pre-cur==1){
                if (i==s.length()) return true;
                if (find(s.substring(i),cur)){
                    return true;
                }
            }
            if(cur>=pre){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="200100";
        System.out.println(splitString(s));
    }
}
