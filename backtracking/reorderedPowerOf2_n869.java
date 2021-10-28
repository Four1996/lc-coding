package leetcode.backtracking;

/**
 * @program: first
 * @description: 重新排序得到2的幂
 * @author: panhao
 * @date: 2021-10-28 19:39
 **/
public class reorderedPowerOf2_n869 {
    boolean[] vis;
    boolean tag = false;

    public boolean reorderedPowerOf2(int n) {
        String temp = String.valueOf(n);
        char[] chars = temp.toCharArray();
        int l = chars.length;
        vis = new boolean[l];
        StringBuilder s = new StringBuilder();
        dfs(chars, s);
        return tag;
    }

    public void dfs(char[] chars, StringBuilder s) {
        if (s.length() == chars.length) {
            if (check(s.toString())) {
                tag = true;
            }
            return;
        }
        if (!tag) {
            for (int i = 0; i < chars.length; i++) {
                if (!vis[i]) {
                    if (!tag) {
                        s.append(chars[i]);
                        vis[i] = true;
                        dfs(chars, s);
                        vis[i] = false;
                        s.deleteCharAt(s.length() - 1);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    boolean check(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int n = Integer.parseInt(s);
        int num = 1;
        while (num < n) {
            num *= 2;
        }
        return num == n;
    }

    public static void main(String[] args) {
        reorderedPowerOf2_n869 r=new reorderedPowerOf2_n869();
        System.out.println(r.reorderedPowerOf2(10));
    }
}
