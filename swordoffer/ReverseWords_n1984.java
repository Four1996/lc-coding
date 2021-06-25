package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月05日 10:18 上午
 */
public class ReverseWords_n1984 {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=s1.length-1;i>=0;i--){
            if (!s1[i].equals("")) sb.append(s1[i]+" ");

        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(new ReverseWords_n1984().reverseWords(s));
    }
}
