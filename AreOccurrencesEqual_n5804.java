package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-24 22:30
 **/
public class AreOccurrencesEqual_n5804 {
    public boolean areOccurrencesEqual(String s) {
        int len=s.length();
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<len;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        int pre=0;
        int idx=0;
        for (Map.Entry<Character, Integer> entry:map.entrySet()){
            if (idx==0){
                pre=entry.getValue();
                idx++;
            }else{
                if (pre!=entry.getValue()) return false;
            }
        }
        return true;
    }
}
