package leetcode.swordoffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年05月30日 7:22 下午
 */
public class Permutation_n1959 {
    public String[] permutation(String s) {
        Set<String> set=new HashSet<>();
        boolean[] visited=new boolean[s.length()];
        dfs(s.toCharArray(),"",set,visited);
        String[] ans=new String[set.size()];
        int idx=0;
        for (String s1 : set) {
            ans[idx++]=s1;
        }
        return ans;
    }
    void dfs(char[] c, String res, Set<String> set, boolean[] visited){
        if (res.length()==c.length){
            set.add(res);
            return;
        }
        for (int i=0;i<c.length;i++){
            if (visited[i]) continue;
            visited[i]=true;
            dfs(c, res+c[i],set,visited);
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        String s="abb";
        for (String s1 : new Permutation_n1959().permutation(s)) {
            System.out.println(s1);
        }
    }
}
