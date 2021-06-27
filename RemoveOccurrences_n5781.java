package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-26 22:46
 **/
public class RemoveOccurrences_n5781 {
    public static String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s=s.replace(part,"");
        }
        return s;
    }

    public static void main(String[] args) {
        String s="axxxxyyyyb";
        String part="xy";
        System.out.println(removeOccurrences(s,part));
    }
}
