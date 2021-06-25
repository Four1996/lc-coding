package leetcode;

import java.sql.SQLOutput;

/**
 * @author panhao
 * @date 2021年05月15日 10:45 下午
 */
public class MemLeak_5743 {
    public int[] memLeak(int memory1, int memory2) {
        int[] ans=new int[3];
        int i=1;
        while (true){
            if (i>memory1&&i>memory2) break;
            else if (memory1>=memory2){
                memory1=memory1-i;
            }else{
                memory2=memory2-i;
            }
            i++;
        }
        ans[0]=i;
        ans[1]=memory1;
        ans[2]=memory2;
        return ans;
    }

    public static void main(String[] args) {
        for (int i:new MemLeak_5743().memLeak(8, 11)){
            System.out.println(i);
        }

    }
}
