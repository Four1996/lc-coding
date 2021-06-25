package leetcode;

public class NumDistinct {
    public static int numDistinct(String s, String t) {
//        int count = 0;
//        char[] s_char = s.toCharArray();
//        char[] t_char = t.toCharArray();
////        int cursor_j = 0, j = 0;
////        if (t_char.length != 0 || s_char.length != 0) {
////            int cursor_i = s.indexOf(t_char[cursor_j]);
////            if (cursor_i != -1 && cursor_i + 1 != s.length()) {
////                //到这里表示在上边第一个字符已经匹配到
////                String substr = s.substring(cursor_i + 1, s.length());
////                cursor_j++;
////
////            } else {
////                return 0;
////            }
////
////
////        } else {
////            return 0;
////        }
//        int cursor = 0, number = 0,j=0;
//        int judge[] = new int[t_char.length];
//        for (int i = 0; i < s_char.length; i++) {
//            if (number == judge.length) {
//                break;
//            } else {
//
//                if (s_char[i] - t_char[j] == 0 && count == 0) {//这里表示从子字符串的最开始进行目标字符串匹配
//                    cursor = i;//标记刚开始的时候的字符串落位。
//                    judge[count] = 1;
//                    count++;
//                    j++;
//                }
//                if (s_char[i] - t_char[j] == 0 && count != 0) {
//                    judge[count] = 1;
//                    count++;
//                    j++;
//                }
//                if(count==judge.length){//表示匹配成功一次时
//                    number++;
//                    j--;
//                    count--;
//                    judge[count]=0;
//                }
//                if(s_char[i] - t_char[j] !=0&&i==s_char.length-1){
//                    cursor++;
//                    i=cursor;
//                }
//            }
//
//        }
//
//        return number;

//        ------------------------------------------------------------------------------------------
//        我们发现当sub_s新增了一个长度后，如果新增的字符（当前sub_s尾字符），与sub_t尾字符不匹配，那么
//        似乎在sub_s上多了个"没用"的字符，sub_s所有子序列字符串中sub_t出现的次数没有任何变化。因此在这
//        种状态下：dp[i][j]=dp[i-1][j];
//        如果新加入sub_s的这个字符与sub_t尾字符相匹配时，在没有增加这个字符的情况下，sub_t出现的次数是
//        dp[i-1][j], 现在增加了并且和sub_t尾字符相匹配，因此还要在这个基础上加上两者此前的状态下的次数，
//        即dp[i-1][j-1]，因为相比此前，两者都多了同一个字符，与两者没有加上这个相同字符时情况是一样的。
//        因此这种情况下总和是dp[i-1][j]+dp[i-1][j-1].

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];


    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int n = numDistinct(s, t);
        System.out.println(n);
//        System.out.println('a'+'b');
    }
}
