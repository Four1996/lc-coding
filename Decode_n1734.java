package leetcode;

/**
 * @author panhao
 * @date 2021年05月11日 8:40 上午
 */
public class Decode_n1734 {
    public static int[] decode(int[] encoded) {
        int[] ans=new int[encoded.length+1];
        int totalxor=1;
        for (int i=2;i<= encoded.length+1;i++){
            totalxor^=i;
        }
        int oddxor=0;
        for (int i=1;i< encoded.length;i+=2){
            oddxor^=encoded[i];
        }
        int first=totalxor^oddxor;
        ans[0]=first;
        for (int i=1;i<ans.length;i++){
            ans[i]=encoded[i-1]^ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={3,1};
        for (int i:decode(nums)){
            System.out.println(i);
        }
    }
}
