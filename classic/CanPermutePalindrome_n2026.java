package leetcode.classic;

import test.ProxyTest.Lenovo;
import test.demo10_WaitAndNotify.Baozi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 回文排列
 * @author: panhao
 * @date: 2021-06-21 09:18
 **/
public class CanPermutePalindrome_n2026 {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean tag=true;
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            Integer value = entry.getValue();
            if (value%2==1){
                if (tag) tag=false;
                else return false;
            }else{
                if (value%2!=0) return false;
            }
        }
        return true;
    }
}
