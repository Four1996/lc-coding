package leetcode;

/**
 * @author panhao
 * @date 2021年04月18日 6:52 下午
 */
public class PlusOne_n66 {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] == 9) {
            for (int i=digits.length-1;i>=0;i--){
                digits[i]++;
                digits[i]%=10;
                if (digits[i]!=0) return digits;
            }
            digits=new int[digits.length+1];
            digits[0]=1;
            return digits;
        }
        digits[digits.length - 1]++;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne_n66 plusOne_n66 = new PlusOne_n66();
        int[] nums = {9, 9, 9, 9, 9};
        plusOne_n66.plusOne(nums);
    }
}
