package leetcode;

/**
 * @author panhao
 * @date 2021年05月23日 11:13 上午
 */
public class CanReach_n5765_2 {
    public static boolean canReach(String s, int minJump, int maxJump) {
        int len=s.length();
        int[] dp=new int[len];
        int[] pre=new int[len];
        for (int i=0;i<minJump;i++){
            pre[i]=1;
        }
        for (int i=minJump;i<len;i++){
            int left=i-maxJump,right=i-minJump;
            if (s.charAt(i)=='0') {
                int total=pre[right]-(left<=0?0:pre[left-1]);
                dp[i]=total==0?0:1;
            }
            pre[i]=pre[i-1]+dp[i];
        }
        return dp[len-1]==1?true:false;
    }


    public static void main(String[] args) {
        String s="011010";
        System.out.println(canReach(s,2,3));
    }
}
