package leetcode.strings;

/**
 * @program: first
 * @description: Z字形变换
 * @author: panhao
 * @date: 2021-08-16 10:23
 **/
public class Convert_n6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        int[] d = new int[numRows - 1];
        for (int i = 0; i < numRows - 1; i++) {
            d[i] = (numRows - i - 1) * 2;
        }
        int max = d[0];
        int dIdx = 0;
        for (int i = 0; i < numRows; i++) {
            int j = i;
            boolean tag = true;
            while (j < len) {
                sb.append(chars[j] + "");
                if (tag || dIdx == 0) {
                    j += d[dIdx];
                    tag = false;
                } else {
                    j += (max - d[dIdx]);
                    tag = true;
                }
            }
            dIdx = (dIdx + 1) % (numRows - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
