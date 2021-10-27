package leetcode;

/**
 * @program: first
 * @description: 65.有效数字
 * @author: panhao
 * @date: 2021-06-17 08:34
 **/
public class IsNumber_n65_2 {
    public boolean isNumber(String s) {
        if (s.contains("f") || s.contains("N") || s.contains("J") || s.contains("D") || s.contains("d")) {
            return false;
        }
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
