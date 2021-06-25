package leetcode;

/**
 * @author panhao
 * @date 2021年05月30日 10:30 上午
 */
public class IsSumEqual_n5772 {
    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        StringBuilder sb3=new StringBuilder();
        for (int i=0;i<firstWord.length();i++){
            int cur=firstWord.charAt(i)-'a';
            sb1.append(cur);
        }
        for (int i=0;i<secondWord.length();i++){
            int cur=secondWord.charAt(i)-'a';
            sb2.append(cur);
        }
        for (int i=0;i<targetWord.length();i++){
            int cur=targetWord.charAt(i)-'a';
            sb3.append(cur);
        }
        int f= Integer.parseInt(sb1.toString());
        int s= Integer.parseInt(sb2.toString());
        int t= Integer.parseInt(sb3.toString());
        if (f+s==t) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSumEqual("aaa","a","aab"));
    }
}
