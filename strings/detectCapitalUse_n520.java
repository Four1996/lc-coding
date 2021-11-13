package leetcode.strings;

/**
 * @program: first
 * @description: 检测大写字母
 * @author: panhao
 * @date: 2021-11-13 20:37
 **/
public class detectCapitalUse_n520 {
    public boolean detectCapitalUse(String word) {
        String temp = word.toUpperCase();
        if (temp.equals(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == temp.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
