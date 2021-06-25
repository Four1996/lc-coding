package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月03日 8:57 上午
 */
public class KSimilarity_n854 {
    //    static int k = 0;
//    public static int kSimilarity(String s1, String s2) {
//        int l1 = s1.length(), l2 = s2.length();
//        if (l1 != l2) return -1;
//        while (s1.charAt(0) == s2.charAt(0)) {
//            s1 = s1.substring(1);
//            s2 = s2.substring(1);
//            if (s1.length()==0||s2.length()==0) return 0;
//        }
//        char[] a1 = s1.toCharArray();
//        char[][] a2 = new char[s2.length()][2];
//        for (int i=0;i<s2.length();i++){
//            a2[i][0]=s2.charAt(i);
//            if (s1.charAt(i)==s2.charAt(i)) a2[i][1]='z';
//            else a2[i][1]='g';
//
//        }
//        dfs(a1, 0, a2, 0);
//        return k;
//    }
//    static void dfs(char[] a1, int index1, char[][] a2, int index2) {
//        if (index1==a1.length-1){
//            return;
//        }else{
//            while (a2[index2][0] != a1[index1]||a2[index2][1]=='z') {
//                index2++;
//                if (index2==a2.length) return;
//            }
//            char temp = a2[index2][0];
//            a2[index2][0] = a2[index1][0];
//            a2[index1][0] = temp;
//            a2[index1][1]='z';
//            k++;
//            index1++;
//            index2 = index1;
//            while (a1[index1]==a2[index2][0]){
//                index1++;
//                index2++;
//                if (index1==a1.length||index2==a2.length) return;
//            }
//            dfs(a1,index1,a2,index2);
//        }
//    }
    public static int kSimilarity(String A, String B) {
        Queue<String> queue = new ArrayDeque();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) return dist.get(S);
            for (String T : neighbors(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
    }

    public static List<String> neighbors(String S, String target) {
        List<String> ans = new ArrayList();
        int i = 0;
        for (; i < S.length(); ++i) {
            if (S.charAt(i) != target.charAt(i)) break;
        }

        char[] T = S.toCharArray();
        for (int j = i + 1; j < S.length(); ++j)
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }

        return ans;
    }

    public static void swap(char[] T, int i, int j) {
        char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }

    public static void main(String[] args) {
        String s1 = "abcdeabcdeabcdeabcde";
        String s2 = "aaaabbbbccccddddeeee";
        System.out.println(kSimilarity(s1, s2));
    }
}
