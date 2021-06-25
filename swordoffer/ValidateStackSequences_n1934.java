package leetcode.swordoffer;

import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月19日 8:45 下午
 */
public class ValidateStackSequences_n1934 {
    static Stack<Integer> stack=new Stack<>();
    static int cur=0;
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int len=popped.length;
        if (len==0) return true;
        for (int i=0;i<len;i++){
            if (stack.contains(popped[i])){
                    if (stack.peek()!=popped[i]) return false;
                    else stack.pop();
            }
            else{
                int u=popped[i];
                stackHelper(pushed,u);
            }
        }
        return true;
    }
    static void stackHelper(int[] pushed,int u){
        while (pushed[cur]!=u){
            stack.push(pushed[cur]);
            cur++;
        }
        cur++;
    }
    public static void main(String[] args) {
        int[] pushed ={1,2,3,4,5};
        int[] popped={4,3,5,1,2};
        System.out.println(validateStackSequences(pushed,popped));
    }
}
