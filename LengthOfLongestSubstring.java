package leetcode;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static int lengthoflongestSubstring(String s){
        if (s.length()==0){
            return 0;
        }else {
            int count=0;
            int maxcount=0;
            char[] sarray=s.toCharArray();
            HashMap<Character,Integer> sub=new HashMap<>(s.length()-1);
            int tag=0;
            for (int i=0;i<s.length();i++){
                boolean judge=sub.containsKey(sarray[i]);
                if (judge){
                    tag=sub.get(sarray[i]);

                    i=tag+1;

                    sub.clear();
                    maxcount=Math.max(maxcount,count);
                    sub.put(sarray[i],i);
                    count=1;

                }else{
                    sub.put(sarray[i],i);
                    count++;
                }

            }
            maxcount=Math.max(maxcount,count);
            return maxcount;
        }
    }
    public static void main(String[] args) {
        System.out.println(lengthoflongestSubstring("aabaaaa"));
    }
}
