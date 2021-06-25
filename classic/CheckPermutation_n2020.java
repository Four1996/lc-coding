package leetcode.classic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 判定是否互为字符重排
 * @author: panhao
 * @date: 2021-06-20 10:24
 **/
public class CheckPermutation_n2020 {
    public static boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (chars1.length!=chars2.length)  return false;
        for (int i=0;i<chars1.length;i++){
            if (chars1[i]!=chars2[i]) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="bca";
        System.out.println(CheckPermutation(s1,s2));
    }
}
