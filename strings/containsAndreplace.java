package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 实现将A中包含的的B字符串替换为C字符串
 * @author: panhao
 * @date: 2021-08-24 18:07
 **/
public class containsAndreplace {
    static int patternLength;
    // 偏移表
    static HashMap<Character,Integer> shift;

    // 字符串匹配
    public static int sunday(String string, String pattern){
        int l1= string.length(),l2=pattern.length();
        if (l2==0){
            return 0;
        }
        if (l2>l1){
            return -1;
        }
        for (int i=0,j=0;i<l1;){
            int head=i;
            int tail=i+l2;
            while (i<l1&&j<l2&& string.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if (j==l2){
                return i-l2;
            }
            if (i==l1||tail>=l1){
                return -1;
            }
            if (shift.containsKey(string.charAt(tail))){
                i=head+ shift.get(string.charAt(tail));
            }else{
                i=head+patternLength+1;
            }
            j=0;
        }
        return -1;
    }
    public static String replace(String string,String pattern,String rep){
        String ans=string;
        int idx;
        while ((idx=sunday(ans,pattern))!=-1){
            String head=ans.substring(0,idx);
            String tail=ans.substring(idx+patternLength);
            ans=head+rep+tail;
        }
        return ans;
    }
    public static void main(String[] args) {
        String A="abcbbabbac";
        String B="bba";
        String C="cc";
        patternLength=B.length();
        shift=new HashMap<>();
        for (int i = 0; i < patternLength; i++) {
            shift.put(B.charAt(i),patternLength-i);
        }
        System.out.println(replace(B,A,C));
    }
}
