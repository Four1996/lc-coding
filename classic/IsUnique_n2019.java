package leetcode.classic;

import java.util.HashSet;

/**
 * @program: first
 * @description: 判断字符是否唯一
 * @author: panhao
 * @date: 2021-06-20 10:20
 **/
public class IsUnique_n2019 {
    public boolean isUnique(String astr) {
        HashSet<Character> set=new HashSet<>();
        for (int i=0;i<astr.length();i++){
            if (set.contains(astr.charAt(i))) return false;
            set.add(astr.charAt(i));
        }
        return true;
    }
}
