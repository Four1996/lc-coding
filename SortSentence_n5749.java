package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月15日 10:31 下午
 */
public class SortSentence_n5749 {
    public String sortSentence(String s) {
        String ans="";
        String[] s1 = s.split(" ");
        HashMap<Integer,String> map=new HashMap<>();
        for (int i=0;i<s1.length;i++){
            int len=s1[i].length();
            int a=Integer.valueOf(s1[i].charAt(len-1)-48);
            map.put(a,s1[i].substring(0,len-1));
        }
        for (int i=1;i<=s1.length;i++){
            if (i==s1.length) ans+=map.get(i);
            else ans+=map.get(i)+" ";

        }
        return ans;
    }

    public static void main(String[] args) {

        String s="Myself2 Me1 I4 and3";
        System.out.println(new SortSentence_n5749().sortSentence(s));
    }
}
