package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-07 22:30
 **/
public class MakeFancyString_n5193 {
    public static String makeFancyString(String s) {
        int len=s.length();
        if (len<3) return s;
        char[] chars = s.toCharArray();
        char c=chars[0];
        for (int i=1;i<len;i++){
            if (chars[i]==c){
                int count=2;
                i++;
                while (i<len&&chars[i]==c){
                    count++;
                    if (count>2){
                        chars[i]=' ';
                    }
                    i++;
                }
                if (i<len) c=chars[i];
            }else{
                c=chars[i];
            }

        }
        StringBuilder sb=new StringBuilder();
        for (char cc : chars) {
            if (cc==' ') continue;
            sb.append(cc+"");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="aaabaaa";
        System.out.println(makeFancyString(s));
    }
}
