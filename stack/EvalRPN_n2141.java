package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: first
 * @description: 后缀表达式
 * @author: panhao
 * @date: 2021-09-03 15:36
 **/
public class EvalRPN_n2141 {
    public static int evalRPN(String[] tokens) {
        int ans;
        Deque<Integer> deque=new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+")||token.equals("-")||token.equals("/")||token.equals("*")){
                Integer n1 = deque.pollFirst();
                Integer n2 = deque.pollFirst();
                int res=0;
                switch (token){
                    case "+":
                        res=n2+n1;
                        break;
                    case "-":
                        res=n2-n1;
                        break;
                    case "*":
                        res=n2*n1;
                        break;
                    case "/":
                        res=n2/n1;
                        break;
                    default:
                        break;
                }
                deque.addFirst(res);
            }else{
                deque.addFirst(Integer.valueOf(token));
            }
        }
        ans=deque.pollFirst();
        return ans;
    }

    public static void main(String[] args) {
        String[] nums={
                "4","13","5","/","+"
        };
        System.out.println(evalRPN(nums));
    }
}
