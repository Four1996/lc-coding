package leetcode.classic;

/**
 * @program: first
 * @description: 字符串轮转
 * @author: panhao
 * @date: 2021-06-22 20:41
 **/
public class IsFlipedString_n2031_2 {
    public static boolean isFlipedString(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        if (l1!=l2) return false;
        if (s1.equals(s2)) return true;
        for (int i=1;i<l1;i++){
            if (s1.substring(0,i).equals(s2.substring(l2-i))&&s1.substring(i).equals(s2.substring(0,l2-i))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isFlipedString("waterbottle","erbottlewat"));
    }
}
