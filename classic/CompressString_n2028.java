package leetcode.classic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 字符串压缩
 * @author: panhao
 * @date: 2021-06-22 09:47
 **/
public class CompressString_n2028 {
    public static String compressString(String S) {

        int len=S.length();
        if (len<1) return "";
        StringBuilder sb=new StringBuilder();
        int count=0;
        char pre;
        for (int i=0;i<len;){
            sb.append(S.charAt(i));
            pre=S.charAt(i);
            count++;
            i++;
            while (i<len&&S.charAt(i)==pre) {
                count++;
                i++;
            }
            sb.append(count);
            count=0;
        }
        return sb.toString().length()>=len?S:sb.toString();
    }

    public static void main(String[] args) {
        String s="aabcccccaa";
        System.out.println(compressString(s));
    }
}
