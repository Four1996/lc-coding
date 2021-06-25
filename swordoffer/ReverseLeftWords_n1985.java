package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月05日 10:30 上午
 */
public class ReverseLeftWords_n1985 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while (i<n){
            sb.append(s.charAt(i));
            i++;
        }
        sb.insert(0,s.substring(i));
        return sb.toString();
    }
}
