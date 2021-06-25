package leetcode;

/**
 * @program: first
 * @description: 65.有效数字
 * @author: panhao
 * @date: 2021-06-17 08:34
 **/
public class IsNumber_n65 {
    public static boolean isNumber(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int len = s.length();
        if (len < 1) return false;
        if (len == 1) {
            if (s.charAt(0) < '0' || s.charAt(0) > '9') return false;
        }
        // char pre = ' ';
        boolean symbol = false;
        boolean char_tag = false;
        // boolean point_tag = false;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') idx++;
            else break;
        }
        String integer = "";
        String decimals = "";
        if (idx >= len) {
            integer = s;
        } else {
            integer = s.substring(0, idx);
            decimals = s.substring(idx + 1);
        }
        for (int i = 0; i < integer.length(); i++) {
            char c = integer.charAt(i);
            if (i == 0) {
                if ((c < '0' || c > '9')) return false;
            } else {
                if (c == 'e' || c == 'E') {
                    if (char_tag) return false;
                    else {
                        char_tag = true;
                        if (i == integer.length() - 1) return false;
                        if (decimals.length() >= 0 && idx < s.length()) return false;
                        continue;
                    }
                } else {
                    if (c >= '0' && c <= '9') {
                        // if ((integer.charAt(i-1)=='e'||integer.charAt(i-1)=='E')&&c=='0') return false;
                        continue;
                    } else if (c == '-' || c == '+') {
                        if (integer.charAt(i - 1) != 'e' && integer.charAt(i - 1) != 'E') return false;
                        if (char_tag) {
                            if (symbol) return false;
                            else {
                                if (i == integer.length() - 1) return false;
                                symbol = true;
                                continue;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < decimals.length(); i++) {
            char c = decimals.charAt(i);
            if (c == '.') return false;
            if (i == 0) {
                if (c == 'e' || c == 'E') {
                    if (integer.length() == 0) return false;
                    char_tag = true;
                    if (i == decimals.length() - 1) return false;
                    continue;
                } else if ((c < '0' || c > '9')) {
                    return false;
                }
            } else if (c >= '0' && c <= '9') continue;
            else {
                if (c == 'e' || c == 'E') {
                    if (char_tag) return false;
                    else {
                        if (i == decimals.length() - 1) return false;
                        char_tag = true;
                        continue;
                    }
                } else {
                    if (c == '-' || c == '+') {
                        if (i == decimals.length() - 1) return false;
                        else if (decimals.charAt(i - 1) == 'e' || decimals.charAt(i - 1) == 'E') continue;
                        else return false;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "32.e-80123";
        System.out.println(isNumber(s));
    }
}
