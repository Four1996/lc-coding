package leetcode;

import org.jetbrains.annotations.NotNull;

/**
 * @author panhao
 * @date 2021年04月13日 2:32 下午
 */
public class StrStr_n28 {
    public static int strStr(String haystack,String needle){
        if(haystack==null||needle==null) return -1;
        int l1=haystack.length(),l2=needle.length();
        if (l2==0) return 0;
        int[] next=new int[l2];
        getnext(needle,next);
        int i=0,j=0;
        while (i<l1&&j<l2){
            if (j==-1||haystack.charAt(i)==needle.charAt(j)){
                ++i;++j;
            }
            else{
                j=next[j];
            }
        }
        if (j>=l2) return i-l2;
        else return -1;
    }
    static void getnext(@NotNull String subt, int[] next){
        int i=0,j=-1;
        next[0]=-1;
        while (i<subt.length()-1){
            if (j==-1||subt.charAt(i)==subt.charAt(j)){
                ++i;++j;
                if (subt.charAt(i)==subt.charAt(j)) next[i]=next[j];
                else next[i]=j;
            }else{
                j=next[j];
            }
        }
    }

    public static void main(String[] args) {
        String t="aaaaa";
        String str="bba";
        System.out.println(strStr(t,str));
    }

}
