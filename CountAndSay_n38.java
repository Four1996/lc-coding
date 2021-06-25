package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月14日 10:31 下午
 */
public class CountAndSay_n38 {
    public String countAndSay(int n){
        if (n==1) return "1";
        String str="1";
        for (int i=1;i<+n;i++){
            str=getcountAndSay(str);
        }
        return str;
    }
    public String getcountAndSay(String n){
        int len=n.length();
        if (len==1) return "11";
        List<String> list=new ArrayList<>();
        int i=1,count=1;
        while(i<len){
            if (n.charAt(i)==n.charAt(i-1)) {
                count++;
            }else{
                list.add(String.valueOf(count)+String.valueOf(n.charAt(i-1)));
                count=1;
            }
            i++;
        }
        if (n.charAt(i-1)!=n.charAt(i-2)) list.add("1"+String.valueOf(n.charAt(i-1)));
        else list.add(String.valueOf(count)+String.valueOf(n.charAt(i-1)));
        String ans="";
        for (String ele:list){
            ans+=ele;
        }
        return ans;
    }


    public static void main(String[] args) {
        CountAndSay_n38 countAndSay_n38=new CountAndSay_n38();
        int n=6;
        System.out.println(countAndSay_n38.countAndSay(n));
    }
}
