package leetcode.double_pointer;

/**
 * @program: first
 * @description: 有效的回文
 * @author: panhao
 * @date: 2021-08-31 15:28
 **/
public class isPalindrome_n2122 {
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isLetterOrDigit(aChar)) {
                sb.append(aChar);
            }
        }
        int left = 0, right = sb.length() - 1;
        char[] temp = sb.toString().toLowerCase().toCharArray();
        while (left <= right && temp[left] == temp[right]) {
            left++;
            right--;
        }
        return left > right;
    }

    public static void main(String[] args) {
        String s="0P";
        System.out.println(isPalindrome(s));
    }
}
