package leetcode.strings;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-25 10:43
 **/
public class MaximumNumber_n5824 {
    public String maximumNumber(String num, int[] change) {
        int len=num.length();
        char[] chars = num.toCharArray();
        boolean tag=false;
        char[] c={'0','1','2','3','4','5','6','7','8','9'};
        for (int i=0;i<len;i++){
            int idx=chars[i]-'0';
            if (change[idx]>idx) {
                tag=true;
                chars[i]= c[change[idx]];
            }else if (tag&&change[idx]<idx) break;
        }
        return new String(chars);
    }

    public static void main(String[] args) {

    }
}
