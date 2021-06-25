package leetcode.classic;

/**
 * @program: first
 * @description: 字符串轮转
 * @author: panhao
 * @date: 2021-06-22 20:41
 **/
public class IsFlipedString_n2031 {
    public boolean isFlipedString(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        if (l1!=l2) return false;

        return (s1+s1).indexOf(s2)>-1;
    }
}
