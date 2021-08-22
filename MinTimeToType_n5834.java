package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-21 22:30
 **/
public class MinTimeToType_n5834 {
    public static int minTimeToType(String word) {
        int len=word.length();
        char[] chars = word.toCharArray();
        char pre='a';
        int ans=0;
        for (int i=0;i<len;i++){
            // System.out.println('z'-'a'+1);
            int diff=Math.abs(pre-chars[i]);
            if (diff>=13){
                diff=26-diff;
            }
            // int diff=(pre-chars[i]+26)%('z'-'a'+1);
            ans+=diff+1;
            pre=chars[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("zjpc"));
    }
}
