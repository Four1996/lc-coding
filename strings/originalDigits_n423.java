package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 从英文中重建数字
 * @author: panhao
 * @date: 2021-11-24 18:36
 **/
public class originalDigits_n423 {
    public static String originalDigits(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c : chars) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int[] count=new int[10];
        count[0]=map.getOrDefault('z',0);
        count[8]=map.getOrDefault('g',0);
        count[2]=map.getOrDefault('w',0);
        count[6]=map.getOrDefault('x',0);
        count[4]=map.getOrDefault('u',0);

        count[3]=map.getOrDefault('h',0)-count[8];
        count[5]=map.getOrDefault('f',0)-count[4];
        count[7]=map.getOrDefault('s',0)-count[6];

        count[1]=map.getOrDefault('o',0)-count[0]-count[2]-count[4];
        count[9]=map.getOrDefault('i',0)-count[6]-count[8]-count[5];


        StringBuilder ans=new StringBuilder();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans.append((char)(i+'0'));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s="nnei";
        System.out.println(originalDigits(s));
    }
}
