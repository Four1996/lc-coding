package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: first
 * @description: 最短补全词
 * @author: panhao
 * @date: 2021-12-10 21:35
 **/
public class shortestCompletingWord_n748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            if (Character.isLetter(licensePlate.charAt(i))) {
                map.put(licensePlate.charAt(i), map.getOrDefault(licensePlate.charAt(i), 0) + 1);
            }
        }
        int minLen = Integer.MAX_VALUE;
        String ans = null;

        for (String word : words) {
            word = word.toLowerCase();
            HashMap<Character, Integer> cur = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    cur.put(word.charAt(i), cur.getOrDefault(word.charAt(i), 0) + 1);
                }
            }
            boolean tag = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char key = entry.getKey();
                int num = entry.getValue();
                if (cur.containsKey(key)) {
                    if (num > cur.get(key)) {
                        tag = false;
                        break;
                    }
                } else {
                    tag = false;
                    break;
                }
            }
            if (tag) {
                if (word.length() < minLen) {
                    minLen = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs={"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord("1s3 PSt",strs));
    }
}
