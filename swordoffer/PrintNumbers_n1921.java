package leetcode.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月18日 8:22 下午
 */
public class PrintNumbers_n1921 {
    public int[] printNumbers(int n) {
        List<Integer> res=new ArrayList<>();
        int i=1;
        int max= (int) Math.pow(10,n);
        while (i<=(max-1)){
            res.add(i);
            i++;
        }
        int[] ans=new int[res.size()];
        for (int j = 0; j <res.size(); j++){
            ans[j]=res.get(j);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new PrintNumbers_n1921().printNumbers(1));
    }
}
