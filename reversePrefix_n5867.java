package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-12 10:30
 **/
public class reversePrefix_n5867 {
    public String reversePrefix(String word, char ch) {
        int len=word.length();
        char[] chars = word.toCharArray();
        int idx=0;
        for (int i = 0; i < len; i++) {
            if (chars[i]==ch){
                idx=i;
                break;
            }
        }
        String temp=word.substring(idx+1);
        StringBuilder s=new StringBuilder(word.substring(0,idx+1));
        s=s.reverse();
        return s+temp;
    }
}
