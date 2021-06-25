package leetcode;

import java.util.Stack;
import java.util.TreeMap;

public class Find132Pattern {
    public static boolean find132pattern(int[] nums){
        int n = nums.length;
        if (n < 3) {
            return false;
        }else{
            int ak=Integer.MIN_VALUE;
            Stack<Integer> st=new Stack<>();
            st.push(nums[n-1]);
            for (int i=n-2;i>=0;i--){
                if (nums[i]<ak&&!st.empty()){
                    return true;
                }else{
                    if (nums[i]<=st.peek()){
                        st.push(nums[i]);
                    }else{
                        while (nums[i]>st.peek()){
                            ak=st.pop();
                            if (st.empty()) break;
                        }
                        st.push(nums[i]);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={-1,3,2,0};
        System.out.println(find132pattern(nums));
    }
}
