package leetcode.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月18日 8:22 下午
 */
public class PrintNumbers_n1921_2 {
    StringBuilder res;
    int count=0;
    int n;
    char[] num;
    char[] loop={'0','1','2','3','4','5','6','7','8','9'};
    public String printNumbers(int n) {
        this.n=n;
        res=new StringBuilder();
        num=new char[n];
        dfs(0);
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
    void dfs(int x){
        if (x==n){
            String s="";
            for (char i:num){
                s+=i;
            }
            int u=Integer.valueOf(s);
            res.append(String.valueOf(u)+",");
            return;
        }
        for (char i:loop){
            num[x]=i;
            dfs(x+1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new PrintNumbers_n1921_2().printNumbers(3));
    }
}
