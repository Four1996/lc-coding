package leetcode;

/**
 * @author panhao
 * @date 2021年04月12日 5:01 下午
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int ans=0;
        s=s.replace("IV","a");
        s=s.replace("IX","b");
        s=s.replace("XL","c");
        s=s.replace("XC","d");
        s=s.replace("CD","e");
        s=s.replace("CM","f");
        for (int i=0;i<s.length();i++){
            ans+=getvalue(String.valueOf(s.charAt(i)));
        }
        return ans;
    }
    static int getvalue(String ch){
        switch (ch){
            case "I":return 1;
            case "V":return 5;
            case "X":return 10;
            case "L":return 50;
            case "C":return 100;
            case "D":return 500;
            case "M":return 1000;
            case "a":return 4;
            case "b":return 9;
            case "c":return 40;
            case "d":return 90;
            case "e":return 400;
            case "f":return 900;
            default:return -1;
        }
    }

    public static void main(String[] args) {
        String s = "MCMXCVI";
        System.out.println(romanToInt(s));
    }
}
