package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年04月12日 8:33 下午
 */
public class IsValid_n20 {
    public static boolean isValid(String s){
        int len=s.length();
        if (len%2!=0) return false;
        for (int i=0;i<len/2;i++){
            s=s.replace("()","");
            s=s.replace("{}","");
            s=s.replace("[]","");
        }
        if (s.length()==0) return true;
        return false;
    }

    public static void main(String[] args) {
        String s="{[]}";
        System.out.println(isValid(s));
    }
}
