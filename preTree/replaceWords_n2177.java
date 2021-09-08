package leetcode.preTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 替换单词
 * @author: panhao
 * @date: 2021-09-08 13:41
 **/
public class replaceWords_n2177 {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String[] split = sentence.split(" ");
        int len = split.length;
        for (int i = 0; i < len; i++) {
            String s = split[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j));
                if (set.contains(sb.toString())) {
                    split[i] = sb.toString();
                    break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String s : split) {
            ans.append(s + " ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
