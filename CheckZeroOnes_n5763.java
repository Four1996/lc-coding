package leetcode;

/**
 * @author panhao
 * @date 2021年05月23日 10:30 上午
 */
public class CheckZeroOnes_n5763 {
    public static boolean checkZeroOnes(String s) {
        int count_one=0,count_zero=0;
        for (int i=0;i<s.length();){
            if (s.charAt(i)=='1'){
                int count1=0;
                while (s.charAt(i)=='1'&&i<s.length()){
                    count1++;
                    i++;
                    if (i==s.length()) break;
                }
                count_one=Math.max(count1,count_one);
            }else if (s.charAt(i)=='0'){
                int count0=0;
                while (s.charAt(i)=='0'&&i<s.length()){
                    count0++;
                    i++;
                    if (i==s.length())break;
                }
                count_zero=Math.max(count0,count_zero);
            }
        }
        return count_one>count_zero;
    }

    public static void main(String[] args) {
        String s="0";
        System.out.println(checkZeroOnes(s));
    }
}
