package leetcode;


import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年04月13日 6:55 下午
 */
public class StrStr_n28_3 {
    public static int strStr(String haystack,String needle){//Sunday匹配算法
        if (haystack==null||needle==null) return -1;
        int l1=haystack.length(),l2=needle.length();
        if (l2==0) return 0;
        if (l2>l1) return -1;
        HashMap<Character, Integer> map=new HashMap<>();
        getStep(map,needle);
        for (int i=0,j=0;i<l1;){
            int head=i;
            int tail=i+l2;
            while (haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if (i==l1||j==l2) break;
            }
            if (j==l2) return i-l2;
            if (i==l1||tail>=l1) return -1;
            if (map.containsKey(haystack.charAt(tail))) i=head+map.get(haystack.charAt(tail));
            else i=head+l2+1;
            j=0;
        }
        return -1;
    }
    public static void getStep(HashMap<Character, Integer> map,String needle){
        for (int i=0;i<needle.length();i++){
            map.put(needle.charAt(i),needle.length()-i);
        }
    }

    public static void main(String[] args) {
        String t="aaaaa";
        String pattern="bba";
        System.out.println(strStr(t,pattern));
    }

}
