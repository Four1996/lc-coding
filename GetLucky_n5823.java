package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-25 10:30
 **/
public class GetLucky_n5823 {
    public int getLucky(String s, int k) {
        int len=s.length();
        if (len<1) return 0;
        char[] chars = s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<len;i++){
            sb.append(chars[i]-'a'+1);
        }
        int sum=0;
        while (k>0){
            k--;
            String s1 = sb.toString();
            for (int i=s1.length()-1;i>=0;i--){
                sum+=s1.charAt(i)-'0';
            }
            sb=new StringBuilder(""+sum);
            sum=0;
        }
        return Integer.parseInt(sb.toString());
    }
}
