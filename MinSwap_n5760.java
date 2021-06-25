package leetcode;

/**
 * @author panhao
 * @date 2021年05月16日 10:41 上午
 */
public class MinSwap_n5760 {
    public static int minSwaps(String s) {
        int ans;
        int len=s.length();
        int nums0=0,nums1=0;
        int numsodd1=0;
        for (int i=0;i<len;i++){
            if (i%2==1){
                if (s.charAt(i)=='1') numsodd1++;
            }
            if (s.charAt(i)=='0') nums0++;
            else nums1++;
        }
        if (Math.abs(nums0-nums1)>1) return -1;
        if (len%2==0){
            ans=Math.min(numsodd1,len/2-numsodd1);
        }else{
            if (nums0>nums1){
                ans=nums1-numsodd1;
            }else{
                ans=numsodd1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "00011110110110000000000110110101011101111011111101010010010000000000000001101101010010001011110000001101111111110000110101101101001011000011111011101101100110011111110001100110001110000000001100010111110100111001001111100001000110101111010011001";
        System.out.println(minSwaps(s));
    }
}
