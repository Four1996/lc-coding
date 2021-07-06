package leetcode;

import java.util.Stack;

/**
 * @program: first
 * @description: 比较含退格的字符串
 * @author: panhao
 * @date: 2021-07-06 18:17
 **/
public class BackspaceCompare_n844 {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> ss=new Stack();
        Stack<Character> st=new Stack();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='#'){
                if (!ss.isEmpty()) ss.pop();
            }else{
                ss.push(s.charAt(i));
            }
        }
        for (int i=0;i<t.length();i++){
            if (t.charAt(i)=='#'){
                if (!st.isEmpty()) st.pop();
            }else{
                st.push(t.charAt(i));
            }
        }
        if (ss.size()!=st.size()) return false;
        while (!ss.isEmpty()&&!st.isEmpty()&&ss.peek()==st.peek()) {
            ss.pop();
            st.pop();
        }
        return ss.isEmpty()&&st.isEmpty();
    }

    public static void main(String[] args) {
        String s="abcd";
        String t="bbcd";
        System.out.println(backspaceCompare(s,t));
    }
}
