package leetcode.double_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 字符串中的所有变位词
 * @author: panhao
 * @date: 2021-08-20 09:20
 **/
public class FindAnagrams_n2104_2 {
    public static List<Integer> findAnagrams(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        if (l1 < l2) {
            return new ArrayList<>();
        }

        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < l2; i++) {
            pCount[charsP[i] - 'a']++;
        }
        int classCount = 0;
        for (int num : pCount) {
            if (num > 0) {
                classCount++;
            }
        }
        int winCount = 0;
        int left = 0, right = 0;
        List<Integer> ans = new ArrayList<>();
        while (right < l1) {
            if (pCount[charsS[right] - 'a'] > 0) {
                sCount[charsS[right] - 'a']++;
                if (sCount[charsS[right] - 'a'] == pCount[charsS[right] - 'a']) {
                    winCount++;
                }
            }
            right++;
            while (winCount == classCount) {
                if (right - left == l2) {
                    ans.add(left);
                }
                if (pCount[charsS[left] - 'a'] > 0) {
                    sCount[charsS[left] - 'a']--;
                    if (sCount[charsS[left] - 'a'] < pCount[charsS[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        System.out.println(findAnagrams(s,p));
    }
}
