package leetcode;

import java.beans.beancontext.BeanContext;

/**
 * @author panhao
 * @date 2021年05月30日 10:37 上午
 */
public class MaxValue_n5773 {
    public static String maxValue(String n, int x) {
        String ans="";
        boolean tag = false;
        if (n.charAt(0) != '-') tag = true;
        int i;
        if (tag == true) {
            i = 0;
        } else {
            i = 1;
        }
        if (tag) {
            while (x<=n.charAt(i)-'0') {
                i++;
                if (i==n.length()) break;
            }
        }else{

            while (x>=n.charAt(i)-'0') {
                i++;
                if (i==n.length()) break;
            }
        }
        if (tag==true&&i==n.length()) ans=n+String.valueOf(x);
        else if (tag==false&&i==n.length()) ans=n+x;
        else{
            String pre=n.substring(0,i);
            String num= String.valueOf(x);
            String post=n.substring(i);
            ans=pre+num+post;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxValue("-132", 3));
    }
}
