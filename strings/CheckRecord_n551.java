package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 学生出勤记录I
 * @author: panhao
 * @date: 2021-08-17 09:12
 **/
public class CheckRecord_n551 {
    public boolean checkRecord(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('L', 0);
        map.put('P', 0);
        char[] chars = s.toCharArray();
        int countL = 0;
        for (char ch : chars) {
            if (ch == 'A') {
                map.put('A', map.getOrDefault('A', 0) + 1);
                countL = 0;
            }
            if (ch == 'L') {
                map.put('L', map.getOrDefault('L', 0) + 1);
                countL++;
                if (countL == 3) {
                    return false;
                }
            }
            if (ch == 'P') {
                map.put('P', map.getOrDefault('P', 0) + 1);
                countL = 0;
            }
            if (map.get('A') >= 2) {
                return false;
            }
        }
        return true;
    }
}
