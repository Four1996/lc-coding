package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-08 10:51
 **/
public class MinSwaps_n5840 {
    public static int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int ans=0;
        int left =0;
        for (char c : chars) {
            if (c=='['){
                left++;
            }else{
                if (left ==0){
                    ans++;
                    left++;
                }else{
                    left--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="]]][[[";
        System.out.println(minSwaps(s));
    }
}
