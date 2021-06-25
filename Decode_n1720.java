package leetcode;

/**
 * @author panhao
 * @date 2021年05月06日 8:28 上午
 */
public class Decode_n1720 {
    public static int[] decode(int[] encoded, int first) {
        int[] ans=new int[encoded.length+1];
        ans[0]=first;
        for (int i=0;i<encoded.length;i++){
            ans[i+1]=ans[i]^encoded[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        for (int i:decode(nums,1)){
            System.out.println(i);
        }
    }
}
