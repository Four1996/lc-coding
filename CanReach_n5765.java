package leetcode;

/**
 * @author panhao
 * @date 2021年05月23日 11:13 上午
 */
public class CanReach_n5765 {
    static boolean res;
    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length()-1)=='1'||minJump>s.length()-1) return false;
        if ((s.length()-1)>=minJump&&(s.length()-1)<=maxJump) return true;
        res=false;
        for (int i=0+minJump;i<=maxJump&&i<s.length();i++){
            if (s.charAt(i)=='0') res=res||dfs(s,minJump,maxJump,i);
        }
        return res;
    }
    static boolean dfs(String s,int minJump,int maxJump,int index){
        if (index+minJump>=s.length()) return false;
        if ((s.length()-1)>=index+minJump&&(s.length()-1)<=index+maxJump) return true;
        boolean ans=false;
        for (int i=index+minJump;i<=index+maxJump&&i<s.length();i++){
            if (s.charAt(i)=='0') {
                if (dfs(s,minJump,maxJump,i)) return true;
                else ans=ans||dfs(s,minJump,maxJump,i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="011010";
        System.out.println(canReach(s,2,3));
    }
}
