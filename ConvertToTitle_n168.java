package leetcode;

import java.beans.beancontext.BeanContext;

/**
 * @author panhao
 * @date 2021年05月05日 8:12 下午
 */
public class ConvertToTitle_n168 {
    public static String convertToTitle(int columnNumber) {
        char a='A';
       StringBuilder ans=new StringBuilder();
        while (columnNumber!=0){
            int u=columnNumber%26==0?26:columnNumber%26;
            char c= (char) (a+u-1);
            ans.insert(0,c);
            columnNumber=(columnNumber-u)/26;

        }
        return String.valueOf(ans);
    }
    public static void main(String[] args) {
        int n=1;
        System.out.println(convertToTitle(n));
    }
}
