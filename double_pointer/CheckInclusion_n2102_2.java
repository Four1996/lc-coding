package leetcode.double_pointer;

import java.util.HashMap;

/**
 * @program: first
 * @description: 字符串中的变位词
 * @author: panhao
 * @date: 2021-08-19 09:41
 **/
public class CheckInclusion_n2102_2 {
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l2 < l1) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < l1; i++) {
            s1Count[chars1[i] - 'a']++;
        }
        int s1classCount = 0;
        for (int i : s1Count) {
            if (i > 0) {
                s1classCount++;
            }
        }
        int left = 0, right = 0;
        int winCount = 0;
        while (right < l2) {
            if (s1Count[chars2[right] - 'a'] > 0) {
                s2Count[chars2[right] - 'a']++;
                if (s2Count[chars2[right] - 'a'] == s1Count[chars2[right] - 'a']) {
                    winCount++;
                }
            }
            right++;
            while (winCount == s1classCount) {
                if (right - left  == l1) {
                    return true;
                }
                if (s1Count[chars2[left] - 'a'] > 0) {
                    s2Count[chars2[left] - 'a']--;
                    if (s2Count[chars2[left] - 'a'] < s1Count[chars2[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
