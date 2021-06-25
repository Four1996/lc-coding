package leetcode;

import java.util.Stack;

public class EvalRPN {
    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
    public  static int evalRPN(String[] tokens){
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (isNumber(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
            }else{
                int numb=st.pop(),numa=st.pop();
                switch (tokens[i]){
                    case "-":
                        st.push(numa-numb);
                        break;
                    case "+":
                        st.push(numa+numb);
                        break;
                    case "*":
                        st.push(numa*numb);
                        break;
                    case "/":
                        st.push(numa/numb);
                        break;
                    default:
                        break;
                }
            }
        }
        if (!st.empty()){
            return st.pop();
        }else{
            throw new IllegalArgumentException("无结果！");
        }
    }
    public static void main(String[] args) {
        String[] s={"2","1","+","3","*"};
        System.out.println(evalRPN(s));
    }
}
