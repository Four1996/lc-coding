package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 学生出勤记录I
 * @author: panhao
 * @date: 2021-08-17 09:12
 **/
public class CheckRecord_n551_2 {
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
