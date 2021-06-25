package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月26日 8:43 上午
 */
public class ReverseParentheses_n1190 {
    public static String reverseParentheses(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (stack.isEmpty()&&s.charAt(i)!='(') ans+=s.charAt(i);
            else{
                if (s.charAt(i)!=')') stack.push(s.charAt(i));
                else{
                    Queue<Character> q=new LinkedList<>();
                    while (stack.peek()!='(') q.add(stack.pop());
                    stack.pop();
                    if (stack.isEmpty()){
                        while (!q.isEmpty()) ans+=q.poll();
                    }else{
                        while (!q.isEmpty()){
                            char c=q.poll();
                            stack.push(c);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses(s));
    }
}
