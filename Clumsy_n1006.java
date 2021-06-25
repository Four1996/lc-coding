package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年04月01日 8:46 上午
 */
public class Clumsy_n1006 {
    public static int clumsy(int N){
        Queue<String> que=new LinkedList<String>();
        int result=N;
        if (N==0) return 0;
        if (N==1) return 1;
        que.offer("*");
        que.offer("/");
        que.offer("+");
        que.offer("-");
        while (N>1){
            String str=que.poll();
            switch (str){
                case "*":
                    result=result*(N-1);
                    N--;
                    que.offer(str);
                    break;
                case "/":
                    result=result/(N-1);
                    N--;
                    que.offer(str);
                    break;
                case "+":
                    result=result+(N-1);
                    N--;
                    que.offer(str);
                    break;
                case "-":
                    if (N-3>0){
                        que.offer(str);
                        String str1= que.poll();//*运算
                        que.offer(str1);
                        str1=que.poll();//除运算
                        que.offer(str1);
                        int mid=(N-1)*(N-2)/(N-3);
                        result=result-mid;
                        N=N-3;
                    }else if (N-2>0){
                        que.offer(str);//乘运算
                        String str1= que.poll();
                        que.offer(str1);
                        int mid=(N-1)*(N-2);
                        result=result-mid;
                        N=N-2;
                    }else{
                        result=result-(N-1);
                        N--;
                        que.offer(str);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n=11;
        System.out.println(clumsy(n));
    }
}
