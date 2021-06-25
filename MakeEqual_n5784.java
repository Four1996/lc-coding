package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年06月13日 10:30 上午
 */
public class MakeEqual_n5784 {
    public static boolean makeEqual(String[] words) {
        if (words.length<2) return true;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        HashMap<Character,Integer> map=new HashMap<>();
        int len=words.length;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i< words.length;i++){
            String str=words[i];
            sb.append(str);
            for (int j=0;j<str.length();j++){
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
            }
        }
        if (sb.length()%len!=0) return false;
        if (map.size()==1) return true;
        else{
            for (Map.Entry<Character, Integer> entry:map.entrySet()){
                if (entry.getValue()%len!=0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s={"abc","bca"};
        System.out.println(makeEqual(s));
    }
}
