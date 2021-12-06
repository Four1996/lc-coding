package leetcode.strings;

/**
 * @program: first
 * @description: 截断句子
 * @author: panhao
 * @date: 2021-12-06 09:53
 **/
public class truncateSentence_n1816 {
    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        for (String s1 : split) {
            idx++;
            if (idx == k) {
                ans.append(s1);
            } else {
                ans.append(s1 + " ");
            }
            if (idx == k) {
                break;
            }
        }
        return ans.toString();
    }
}
