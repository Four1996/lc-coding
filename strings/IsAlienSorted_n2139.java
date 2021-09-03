package leetcode.strings;

/**
 * @program: first
 * @description: 外星语言是否排序
 * @author: panhao
 * @date: 2021-09-03 10:52
 **/
public class IsAlienSorted_n2139 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < index.length; i++) {
            index[order.charAt(i)-'a']=i;
        }
        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int l1 = w1.length(), l2 = w2.length();
            for (int j = 0; j < Math.max(l1, l2); j++) {
                int i1 = j >= l1 ? -1 : index[w1.charAt(j) - 'a'];
                int i2 = j >= l2 ? -1 : index[w2.charAt(j) - 'a'];
                if (i1 > i2) {
                    return false;
                }
                if (i1<i2){
                    break;
                }
            }
        }
        return true;
    }
}
