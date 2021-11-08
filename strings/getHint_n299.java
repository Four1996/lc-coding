package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 猜数字游戏
 * @author: panhao
 * @date: 2021-11-08 21:26
 **/
public class getHint_n299 {
    public String getHint(String secret, String guess) {
        char[] oriStr = secret.toCharArray();
        char[] hintStr = guess.toCharArray();
        int len=oriStr.length;
        HashMap<Character, Integer> ori=new HashMap<>();
        HashMap<Character,Integer> hint=new HashMap<>();
        int countA=0,countB=0;
        boolean[] vis=new boolean[len];
        for (int i = 0; i < len; i++) {
            ori.put(oriStr[i],i);
            hint.put(hintStr[i],i);
            if (oriStr[i]==hintStr[i]){
                countA++;
                vis[i]=true;
            }

        }

        return null;
    }
}
