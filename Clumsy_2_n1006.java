package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author panhao
 * @date 2021年04月01日 9:44 上午
 */
public class Clumsy_2_n1006 {
    public static int clumsy_2_n1006(int N){//思路：将加减法看成每个数自带的符号，即正数就是默认的加法，减法看成是负数，利用栈在放入栈的过程中
        // 只计算乘除法。最后只需要把栈中的结果全部相加就可以了。
        int result=0;
        if (N==0) return 0;
        if (N==1) return 1;
        Deque<Integer> deq=new LinkedList<>();
        deq.push(N);
        N--;
        int index=0;//用于控制加减乘除。
        while (N>0){
            if (index%4==0){
                deq.push(deq.pop()*N);
            }else if(index%4==1){
                deq.push(deq.pop()/N);
            }else if(index%4==2){
                deq.push(N);
            }else{
                deq.push(-N);
            }
            index++;
            N--;
        }
        while(!deq.isEmpty()){
            result+=deq.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int N=10;
        System.out.println(clumsy_2_n1006(N));

    }
}
