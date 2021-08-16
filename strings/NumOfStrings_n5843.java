package leetcode.strings;

/**
 * @program: first
 * @description: 作为子字符串出现在单词中的字符串数目
 * @author: panhao
 * @date: 2021-08-15 19:56
 **/
public class NumOfStrings_n5843 {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) ans++;
        }
        return ans;
    }
}
