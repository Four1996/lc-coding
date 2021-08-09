package leetcode.math;

/**
 * @program: first
 * @description: 二进制加法
 * @author: panhao
 * @date: 2021-08-08 21:27
 **/
public class AddBinary_n2082 {
    public static String addBinary(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        StringBuilder sb = new StringBuilder();
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        l1--;
        l2--;
        int add = 0;
        while (l1 >= 0 && l2 >= 0) {
            int cur = ac[l1] - '0' + bc[l2] - '0'+add;
            add = cur / 2 ;
            cur = cur % 2 ;
            sb.insert(0, cur + "");
            l1--;
            l2--;
        }
        if (l1 >= 0 || l2 >= 0) {
            while (l1 >= 0) {
                int cur = ac[l1] - '0'+add;
                add = cur / 2;
                cur = cur % 2;
                sb.insert(0, cur);
                l1--;
            }
            while (l2 >= 0) {
                int cur = bc[l2] - '0' +add;
                add = cur / 2;
                cur = cur % 2;
                sb.insert(0, cur);
                l2--;
            }
        }
        if (add > 0) {
            sb.insert(0, add);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a="11";
        String b="10";
        System.out.println(addBinary(a,b));
    }
}
