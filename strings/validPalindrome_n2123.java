package leetcode.strings;

/**
 * @program: first
 * @description: 最多删除一个字符得到回文
 * @author: panhao
 * @date: 2021-08-31 15:56
 **/
public class validPalindrome_n2123 {
    public boolean validPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int left=0,right=len-1;
        while (left<right) {
            while (left<right&&chars[left]==chars[right]){
                left++;
                right--;
            }
            if (left<right) {
                return check(left + 1, right, chars) || check(left, right - 1, chars);
            }
        }
        return true;
    }

    private boolean check(int left, int right, char[] chars) {
        while (left<right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindrome_n2123 v = new validPalindrome_n2123();
        System.out.println(v.validPalindrome("abc"));
    }
}
