package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 10:27 上午
 */
public class ReplaceSpace_n1893 {
    public static String replaceSpace(String s) {
//        s=s.replace(" ","%20");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(replaceSpace(s));
    }
}
