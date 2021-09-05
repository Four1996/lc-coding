package leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 计算器(只能计算0-9的加减乘除)
 * @author: panhao
 * @date: 2021-09-04 21:04
 **/
public class Calculate_n2309 {
    public static int calculate(String s) {
        int len=s.length();
        char[] chars = s.toCharArray();
        // 运算符
        Deque<Character> s1=new ArrayDeque<>();
        // 结果栈
        Deque<Character> s2=new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '-' || c == '+' || c == '*' || c == '(' || c == ')'||c=='/') {
                if (c == ')') {
                    while (!s1.isEmpty() && s1.peekFirst() != '(') {
                        s2.addFirst(s1.pollFirst());
                    }
                    s1.pollFirst();
                } else if (c == '(' || c == '*'||c=='/') {
                    s1.addFirst(c);
                } else {
                    while (!s1.isEmpty() && s1.peekFirst() != '(') {
                        s2.addFirst(s1.pollFirst());
                    }
                    s1.addFirst(c);
                }
            } else if (c == ' ') {
                continue;
            } else {
                s2.addFirst(c);
            }
        }
        while (!s1.isEmpty()){
            s2.addFirst(s1.pollFirst());
        }
        Deque<Integer> deque=new ArrayDeque<>();
        while (!s2.isEmpty()){
            char c=s2.pollLast();
            if (Character.isDigit(c)){
                deque.addFirst(c-'0');
            }else{
                int num1=deque.pollFirst();
                int num2=deque.pollFirst();
                switch (c){
                    case '-':
                        deque.addFirst(num2-num1);
                        break;
                    case '+':
                        deque.addFirst(num1+num2);
                        break;
                    case '*':
                        deque.addFirst(num1*num2);
                        break;
                    case '/':
                        deque.addFirst(num2/num1);
                        break;
                    default:
                        break;
                }
            }
        }
        return deque.pollFirst();
    }

    public static void main(String[] args) {
        String s=" 3/2 ";
        System.out.println(calculate(s));
    }
}
